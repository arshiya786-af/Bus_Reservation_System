package com.masai.services;

import java.util.List;

import com.masai.models.User;
import com.masai.exceptions.UserException;


public interface UserService {

	public String addUser(User user);
	public String updateUser(User user);
	public User viewUser(int userid)throws UserException ;
	public List<User> viewAllUser();
}