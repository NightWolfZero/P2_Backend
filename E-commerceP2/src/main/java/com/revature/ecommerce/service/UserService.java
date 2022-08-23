package com.revature.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.ecommerce.exception.ResourceNotFoundException;
import com.revature.ecommerce.exception.UserNotFoundException;
import com.revature.ecommerce.model.Users;
import com.revature.ecommerce.repository.UserRepository;

public class UserService {

private final UserRepository ur;
	
	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}

	
	public UserService() {
		this.ur = null;
		
	}

//Change value names accordingly
	public boolean login(String username, String pass) {
		boolean auth=false;
		Users us = ur.findByUsername(username);
		String actPassword = us.getPassword();
		if(actPassword.equals(pass)) {
			auth = true;
		} else {
			System.out.println("Password incorrect");
		}
		return auth;
		
	}
	
	public Users updateUser(Users user) {
		
		return ur.save(user);
	}
	
	public Users getUserByUsername(String username){
		return ur.findByUsername(username);
	}

}