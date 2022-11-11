package com.masai.services;

import com.masai.exceptions.AdminException;
import com.masai.models.Admin;

public interface AdminService {
	
	public Admin createAdmin(Admin admin)throws AdminException;
	
	public Admin updateAdmin(Admin admin,String key)throws AdminException;
}
