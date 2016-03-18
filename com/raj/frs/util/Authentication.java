package com.raj.frs.util;

import com.raj.frs.bean.CredentialsBean;

public interface Authentication {
	public boolean authenticate(CredentialsBean credentialsBean);

	public String authorize(String userId);

	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
}
