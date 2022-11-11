package com.masai.exceptions;

public class UserAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 4L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
}