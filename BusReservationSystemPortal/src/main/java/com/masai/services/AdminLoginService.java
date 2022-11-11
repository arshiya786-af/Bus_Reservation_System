package com.masai.services;

import com.masai.DTO.AdminLoginDTO;
import com.masai.exceptions.LoginException;
import com.masai.models.CurrentAdminSession;

public interface AdminLoginService {
	
	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto)throws LoginException;

	public String logOutFromAdminAccount(String key)throws LoginException;
}
