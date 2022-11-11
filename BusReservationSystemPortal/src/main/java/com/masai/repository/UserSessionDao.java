package com.masai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.CurrentUserSession;


public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer> {
	
	
	public CurrentUserSession findByUuid(String uuid);
	
}
