import os
import subprocess
import shutil
import logging
from pathlib import Path
import argparse
import sys

# --- Setup logging ---
logging.basicConfig(
    level=logging.INFO,
    format='[%(levelname)s] %(message)s'
)
log = logging.getLogger(__name__)

# --- Run Shell Commands ---
def run_cmd(cmd):
    log.debug(f"Running command: {cmd}")
    result = subprocess.run(cmd, shell=True, capture_output=True, text=True)
    if result.returncode != 0:
        log.error(f"Command failed: {cmd}\n{result.stderr}")
        sys.exit(1)
    return result.stdout.strip()

# --- Main Script Logic ---
def main(args):
    repo_path = Path.cwd()

    # Step 1: Create and checkout new branch
    base_branch = run_cmd("git branch --show-current")
    log.info(f"Current base branch: {base_branch}")
    
    run_cmd(f"git checkout -b {args.new_branch}")
    log.info(f"Created and switched to new branch: {args.new_branch}")

    # Step 2: Create new folder in subdirectory
    full_new_folder_path = repo_path / args.subdirectory / args.folder_name
    full_new_folder_path.mkdir(parents=True, exist_ok=True)
    log.info(f"Created new folder: {full_new_folder_path}")

    # Step 3: Copy file maintaining structure
    src_path = repo_path / args.source_file
    if not src_path.exists():
        log.error(f"Source file does not exist: {src_path}")
        sys.exit(1)
    dest_path = full_new_folder_path / src_path.name
    shutil.copy2(src_path, dest_path)
    log.info(f"Copied {src_path} to {dest_path}")

    # Step 4: Edit copied file
    with open(dest_path, "r") as f:
        content = f.read()
    updated_content = content.replace(args.replace_text, args.new_text)
    with open(dest_path, "w") as f:
        f.write(updated_content)
    log.info(f"Replaced text in {dest_path}")

    # Step 5: Commit changes
    run_cmd("git add .")
    run_cmd(f'git commit -m "{args.commit_msg}"')
    log.info("Committed changes")

    # Step 6: Create PR using GitHub CLI
    pr_cmd = (
        f'gh pr create --base master --head {args.new_branch} '
        f'--title "{args.pr_title}" --body "{args.pr_body}"'
    )
    run_cmd(pr_cmd)
    log.info("Pull Request created successfully.")

# --- Argument Parser Setup ---
if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Automate Git branch, folder, file copy/edit, commit and PR")

    parser.add_argument("--new-branch", required=True, help="Name of the new git branch to create")
    parser.add_argument("--subdirectory", required=True, help="Path to the subdirectory where folder will be created")
    parser.add_argument("--folder-name", required=True, help="Name of the new folder to create inside subdirectory")
    parser.add_argument("--source-file", required=True, help="Path to the source file to copy (relative to repo root)")
    parser.add_argument("--replace-text", required=True, help="Text in the file to replace")
    parser.add_argument("--new-text", required=True, help="New text to replace with")
    parser.add_argument("--commit-msg", required=True, help="Git commit message")
    parser.add_argument("--pr-title", required=True, help="Pull request title")
    parser.add_argument("--pr-body", default="", help="Pull request description/body (optional)")

    args = parser.parse_args()
    main(args)