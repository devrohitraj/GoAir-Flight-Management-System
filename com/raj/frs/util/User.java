package com.raj.frs.util;

import com.raj.frs.bean.CredentialsBean;
import com.raj.frs.bean.ProfileBean;

public interface User {
	public String login(CredentialsBean credentialsBean);
	public String register(ProfileBean profileBean);
	public String changePassword(CredentialsBean credentialsBean, String newPassword);
	public boolean logout(String userId);
}
