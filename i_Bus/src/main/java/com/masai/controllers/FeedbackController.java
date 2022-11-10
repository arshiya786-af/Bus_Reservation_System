package com.masai.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BusException;
import com.masai.exceptions.FeedbackException;
import com.masai.exceptions.UserException;
import com.masai.models.Feedback;
import com.masai.services.IFeedbackServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class FeedbackController {

	
	
	@Autowired
	private IFeedbackServices fservice;
	

	@PostMapping("/feedback/user/{busid}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
												@PathVariable("busid") Integer busId,
												@RequestParam(required = false) String key) throws UserException,BusException{
		
		Feedback feedback2 = fservice.addFeedBack(feedback,busId,key);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PutMapping("/feedback/user")
	public ResponseEntity<Feedback> updateFeedback(@Valid @RequestBody Feedback feedback,@RequestParam(required = false) String key) throws FeedbackException, UserException {
		
		Feedback feedback2 = fservice.updateFeedBack(feedback,key);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	

	
	
//	viewFeedback
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) throws FeedbackException {
		
		Feedback feedback2 = fservice.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() throws FeedbackException {
		
		List<Feedback> feedback2 =  fservice.viewFeedbackAll();
		
		return new ResponseEntity<List<Feedback>>(feedback2,HttpStatus.ACCEPTED);
		
	}
	
	
}
