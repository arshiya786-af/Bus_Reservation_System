package com.masai.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.UserException;
import com.masai.models.CurrentAdminSession;
import com.masai.models.CurrentUserSession;
import com.masai.models.User;
import com.masai.repository.AdminSessionDao;
import com.masai.repository.UserDao;
import com.masai.repository.UserSessionDao;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Override
	public User createUser(User user) throws UserException {
		
		User existingUser= userDao.findByMobileNumber(user.getMobileNumber());
		
		if(existingUser != null) 
			throw new UserException("User already registered with this Mobile number!");
			
		
		return userDao.save(user);
	
	}
	@Override
	public User updateUser(User user, String key) throws UserException {
		
		CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to update a User Details!");
		}
		
		if(user.getUserId() == loggedInUser.getUserId()) {
			
			
			return userDao.save(user);
		}
		else
			throw new UserException("Invalid User Details! please login first.");
	}
	
	
	@Override
	public User deleteUser(Integer userId, String key) throws UserException, AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to delete user!");
		}
		User user = userDao.findById(userId).orElseThrow(()-> new UserException("Invalid user Id!"));
		userDao.delete(user);
		return user;
		
		
	}
	@Override
	public User viewUserById(Integer userId, String key) throws UserException, AdminException {

		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to view user datails!");
		}
		
		User user = userDao.findById(userId).orElseThrow(()-> new UserException("Invalid user Id!"));
		return user;
	}
	
	@Override
	public List<User> viewUsers(String key) throws UserException, AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to view all users!");
		}
		
		List<User> userList = userDao.findAll();
		if(userList.isEmpty()) throw new UserException("No users found!");
		
		return userList;
	}
	

}
