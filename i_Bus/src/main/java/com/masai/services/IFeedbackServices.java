package com.masai.services;

import java.util.List;

import com.masai.exceptions.FeedbackException;
import com.masai.models.Feedback;

public interface IFeedbackServices {

public Feedback addFeedBack(Feedback feedBack,Integer busId,String key);
	
	public Feedback updateFeedBack(Feedback feedback,String key) ;
	
	

	public Feedback viewFeedback(Integer id) throws FeedbackException;

	public List<Feedback> viewFeedbackAll() throws FeedbackException;
	
	
}
