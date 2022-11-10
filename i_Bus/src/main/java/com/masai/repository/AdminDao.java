package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	public Admin findByEmail(String email);

}
