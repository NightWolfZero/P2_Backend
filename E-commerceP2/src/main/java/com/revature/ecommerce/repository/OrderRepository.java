package com.revature.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.revature.ecommerce.model.Orders;

@CrossOrigin
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	
	List<Orders>getOrdersByUserID(String userid);
	//List<Orders>getAllOrders();
	
}
