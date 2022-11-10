package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.AvailableAdminSession;

public interface AdminSesionDao extends JpaRepository<AvailableAdminSession, Integer> {
	
	public  AvailableAdminSession findByUuid(String uuid);

}
