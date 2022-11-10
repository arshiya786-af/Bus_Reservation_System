package com.masai.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.catalina.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;


@Entity
@Data
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;
	private Integer driverRating;
	
	@Min(value=1, message="Rating must be in range of 1-5")  
	@Max(value=5, message="Rating must be in range of 1-5") 
	private Integer serviceRating;
	private Integer overallRating;
	private String comments;
	private LocalDate feedbackdate;
	
	
	
	
	public Feedback() {
		
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackId, Integer driverRating,
			@Min(value = 1, message = "Rating must be in range of 1-5") @Max(value = 5, message = "Rating must be in range of 1-5") Integer serviceRatng,
			Integer overallRating, String comments, LocalDate feedbackdate) {
		super();
		this.feedbackId = feedbackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overallRating = overallRating;
		this.comments = comments;
		this.feedbackdate = feedbackdate;
	}
	
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Integer getDriverRating() {
		return driverRating;
	}
	public void setDriverRating(Integer driverRating) {
		this.driverRating = driverRating;
	}
	public Integer getServiceRatng() {
		return serviceRating;
	}
	public void setServiceRatng(Integer serviceRatng) {
		this.serviceRating = serviceRatng;
	}
	public Integer getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public LocalDate getFeedbackdate() {
		return feedbackdate;
	}
	public void setFeedbackdate(LocalDate feedbackdate) {
		this.feedbackdate = feedbackdate;
	}
	
	@OneToOne
	private User users;
	
	@OneToOne
	private Bus bus;
	
	
	
	
	
}
