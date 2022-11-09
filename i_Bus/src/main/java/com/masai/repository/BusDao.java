package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Bus;

public interface BusDao extends JpaRepository<Bus, Integer>{

}
