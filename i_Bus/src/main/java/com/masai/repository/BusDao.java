package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.exceptions.BusException;
import com.masai.models.Bus;

public interface BusDao extends JpaRepository<Bus, Integer>{
	
	@Query("select b.busType from Bus b where b.busType=?1")
	public List<Bus> findByBusType(String BusType);

}
