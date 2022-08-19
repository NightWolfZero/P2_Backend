package com.revature.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.ecommerce.model.Users;


public interface RegistrationRepository extends JpaRepository<Users,Integer> {

	public Users findByUsername(String username);

}
