package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.models.Admin;
import com.masai.models.AvailableAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSesionDao;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSesionDao adminSession;
	

	@Override
	public Admin createAdmin(Admin admin) throws AdminException {
		
		Admin existingAdmin = adminDao.findByEmail(admin.getEmail());
		
		if(existingAdmin != null) {
			throw new AdminException("Admin is already registered with this  Email!..");
		}
		
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		
		AvailableAdminSession currentAdmin= adminSession.findByUuid(key);   //we re checking logged in admin first
		
		if(currentAdmin == null) {
			throw new AdminException("Enter valid key to update Admin details...");
		}
		
		
		if(admin.getAdminId()==currentAdmin.getAdminId()) {
			
			return adminDao.save(admin);
		}
		else {
			throw new AdminException("Invalid Admin details...");
		}
		
	}

}
