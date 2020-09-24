package org.com.capg.healthcare.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.com.capg.healthcare.dao.TestCenterRepository;
import org.com.capg.healthcare.dao.UserRepository;
import org.com.capg.healthcare.entity.DiagnosticCenter;
import org.com.capg.healthcare.entity.Test;
import org.com.capg.healthcare.entity.TestCenter;
import org.com.capg.healthcare.entity.User;
import org.com.capg.healthcare.exception.CenterNotFoundException;
import org.com.capg.healthcare.exception.NameAlreadyExistException;
import org.com.capg.healthcare.exception.TestNotFoundException;
import org.com.capg.healthcare.exception.UserNotFoundException;
import org.com.capg.healthcare.exception.UseralreadyExistException;
import org.com.capg.healthcare.util.TestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;

	@Override
	public String addUser(User user) throws UseralreadyExistException {
		
		Optional<User> userId  = userDao.findById(user.getPhoneNo());
		
		if(userId.isPresent())
		{
			throw new UseralreadyExistException(TestConstants.USER_ALREADY_EXIST);
			
		}
		user.setPhoneNo(user.getPhoneNo());
		userDao.save(user);
		return TestConstants.USER_ADDED;
		
	}
	
	@Override
	public String removeUser(Long PhoneNo) throws UserNotFoundException {
		
Optional<User> userId  = userDao.findById(PhoneNo);
		
		if(userId.isPresent())
		{
			userDao.deleteById(PhoneNo);
			return TestConstants.USER_DELETED;
			
		}
		else
		{
			return TestConstants.USER_NOT_FOUND;
		}


	}
	@Override
	public List<User> getUser(Long userId){

	    	return userDao.findAll();   	
	    }

	
@Override
public ResponseEntity<User> getUserById(Long phoneNo) throws UserNotFoundException {
	User user=userDao.findById(phoneNo).
		   	 orElseThrow(() -> new UserNotFoundException(TestConstants.USER_NOT_FOUND));
		    	return ResponseEntity.ok().body(user);
}
/*
public ResponseEntity<Optional<User>> getUserPhoneNo(Long phoneNo) throws UserNotFoundException {
	
	Optional<User> user=userDao.findById(phoneNo);
			if(user.isPresent()) {
				return ResponseEntity.ok().body(user);
			}
			else
			{
		   	throw new UserNotFoundException(TestConstants.USER_NOT_FOUND);
			}
		    	*/
}	




