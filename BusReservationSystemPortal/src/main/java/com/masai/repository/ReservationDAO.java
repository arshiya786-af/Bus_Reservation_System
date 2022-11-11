package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.models.Reservation;

@Repository
public interface ReservationDAO extends JpaRepository<Reservation, Integer>{
	
	
	
}
