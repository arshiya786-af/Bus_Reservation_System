package com.masai.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.masai.DTO.ReservationDTO;
import com.masai.exceptions.ReservationException;
import com.masai.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(Reservation reservation,int userId,String key) throws ReservationException;
	public Reservation updateReservation(Reservation reservation, int userId,String key) throws ReservationException;
	public Reservation deleteReservation(int reservationId, String key) throws ReservationException;
	public Reservation viewReservation(int reservationId, String key) throws ReservationException;
	public List<Reservation> viewAllReservation(String key) throws ReservationException;
	public List<Reservation> getAllReservation(LocalDate date) throws ReservationException;
	 
	public List<Reservation> viewReservationByUser(String key);

	public Reservation addReservation(ReservationDTO reservationDTO, String key);
	
}
