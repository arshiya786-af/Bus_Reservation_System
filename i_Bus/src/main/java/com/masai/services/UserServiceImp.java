package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.User;
import com.masai.exception.UserAlreadyExistException;
import com.masai.exception.UserNotFoundException;
import com.masai.repository.userdao;
@Service
public class UserServiceImp implements UserService {

	@Autowired UserDao userdao;
	
	@Override
	public String addUser(User user) {
		Optional<User> us = userdao.findById(user.getUserLoginId());
		if(us.isPresent()) {
			throw new UserAlreadyExistException("User with this "+user.getUserLoginId()+" user id is already exist");
		}
		else {
		userdao.save(user);
		return "User record added successfully";
		}
	}

	@Override
	public String updateUser(Users user){
		Optional<User> us = userdao.findById(user.getUserLoginId());
		if(us.isPresent()) {
			userdao.save(user);
			return "User record updated successfully";		
			}
		else {
			throw new UserNotFoundException("This user is not found");
		}
	}


	@Override
	public User viewUser(int userid) {
		Optional<User> user = userdao.findById(userid);
		if(user.isPresent())
		{
			return userdao.findById(userid).get();
		}
		else {
			throw new UserNotFoundException("User of this "+userid+" user id is not found");
		}
		
	}

	@Override
	public List<User> viewAllUsers() {
		return userdao.findAll();
	}

}