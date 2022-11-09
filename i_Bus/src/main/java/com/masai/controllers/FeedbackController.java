package com.masai.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.masai.services.IFeedbackServices;

@RestController
public class FeedbackController {

	
	
	@Autowired
	private IFeedbackServices fservice;
	
	
	
	
}
