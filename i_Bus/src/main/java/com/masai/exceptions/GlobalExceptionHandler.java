package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<errorDetail> EmpException(BusException ee,WebRequest req) {
		 errorDetail err=new errorDetail();
		 
		 err.setTime(LocalDateTime.now());
		 err.setMsg(ee.getMessage());
		 err.setDesc(req.getDescription(false));
		 
		 return new ResponseEntity<errorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	

}
