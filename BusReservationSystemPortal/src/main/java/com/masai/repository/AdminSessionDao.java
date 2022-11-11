package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.CurrentAdminSession;


public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer> {

	public  CurrentAdminSession findByUuid(String uuid);

}
