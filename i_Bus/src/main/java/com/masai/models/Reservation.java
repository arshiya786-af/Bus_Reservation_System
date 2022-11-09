package com.masai.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	private String reservationStatus;
	
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private String source;
	private String destination;
	private LocalDate journeyDate;
	private Integer noOfSeatsBooked;
	private Integer fare;
	
	
	
	
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	
	public Integer getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}
	public void setNoOfSeatsBooked(Integer noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}
	public Integer getFare() {
		return fare;
	}
	public void setFare(Integer fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
				+ ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + ", source=" + source
				+ ", destination=" + destination + ", journeyDate=" + journeyDate + ", noOfSeatsBooked="
				+ noOfSeatsBooked + ", fare=" + fare + "]";
	}
	public Reservation(Integer reservationId, String reservationStatus, LocalDate reservationDate,
			LocalTime reservationTime, String source, String destination, LocalDate journeyDate,
			Integer noOfSeatsBooked, Integer fare) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.noOfSeatsBooked = noOfSeatsBooked;
		this.fare = fare;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
//	@ManyToOne
//	private Bus bus;
//	
//	@ManyToOne
//	private User user;
	
	
	
	
	
}
