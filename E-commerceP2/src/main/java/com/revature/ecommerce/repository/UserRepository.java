package com.revature.ecommerce.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.ecommerce.model.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, Integer>{
    

    public Users findByUsername(String username);
    
  
}