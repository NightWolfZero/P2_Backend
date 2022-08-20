package com.revature.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.ecommerce.model.Users;
import com.revature.ecommerce.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public Users saveUser (Users user) {
		
		
		return repo.save(user);
		
	}
	
	public Users fetchUserByUsername(String username) {
				
		return repo.findByUsername(username);
		
	}
	
}