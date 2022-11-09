package com.masai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.FeedbackException;
import com.masai.models.Feedback;
import com.masai.repository.FeedbackDao;



@Service
public class FeedbackServicesImpl implements IFeedbackServices {
	
	
	@Autowired
	private FeedbackDao fdao;

	@Override
	public Feedback addFeedBack(Feedback feedBack, Integer busId, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback updateFeedBack(Feedback feedback, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedback(Integer id) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewFeedbackAll() throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

}
