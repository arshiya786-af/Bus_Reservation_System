package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.User;
import com.masai.services.UserService;


@RestController
public class UserController {

	@Autowired UserService userservice;
	
	
	
	 @RequestMapping(value = "/adduser", method=RequestMethod.POST)
	 public String addUser(@RequestBody User user) {
		 return userservice.addUser(user);
	 }
	 
	
	 
	 @RequestMapping(value = "/updateuser", method=RequestMethod.PUT)
	 public String updateUser(@RequestBody User user) {
		 return userservice.updateUser(user);
	 }
	 @RequestMapping(value="/getallusers",method=RequestMethod.GET)
		public java.util.List<User> getAllUsers(){
			return userservice.viewAllUser();
		}
}