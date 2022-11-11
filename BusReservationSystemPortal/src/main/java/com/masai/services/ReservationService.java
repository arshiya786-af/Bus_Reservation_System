package com.masai.services;

import java.util.List;

import com.masai.DTO.ReservationDTO;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.BusException;
import com.masai.exceptions.ReservationException;
import com.masai.exceptions.UserException;
import com.masai.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException , BusException,UserException ;
		
	public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, BusException, UserException;
	
	public Reservation viewReservation(Integer reservationId,String key) throws ReservationException, AdminException;
	
	public List<Reservation> viewAllReservation(String key)throws ReservationException;
	
	public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException;
	
}
