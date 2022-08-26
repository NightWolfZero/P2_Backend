package com.revature.ecommerce.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.ecommerce.model.Orders;

@CrossOrigin(origins = "http://localhost:4200")
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	
//	List<Orders>findById(String id);
	
//	List<Orders>getAllOrders(String orderedProduct);
	
}
