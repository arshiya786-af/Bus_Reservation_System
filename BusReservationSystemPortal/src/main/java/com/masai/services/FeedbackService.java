package com.masai.services;

import java.util.List;

import com.masai.exceptions.BusException;
import com.masai.exceptions.FeedBackException;
import com.masai.exceptions.UserException;
import com.masai.models.Feedback;


public interface FeedbackService {
	
	
	public Feedback addFeedBack(Feedback feedBack,Integer busId,String key) throws BusException, UserException;
	
	public Feedback updateFeedBack(Feedback feedback,String key) throws FeedBackException, UserException;
	
	public Feedback deleteFeedBack(Integer feedbackId, String key)throws FeedBackException, UserException;

	public Feedback viewFeedback(Integer id) throws FeedBackException;

	public List<Feedback> viewFeedbackAll() throws FeedBackException;
	
}
