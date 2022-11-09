package com.masai.repository;


	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.masai.models.User;
	@Repository
	public interface UserDao extends JpaRepository<User, Integer>{

	}