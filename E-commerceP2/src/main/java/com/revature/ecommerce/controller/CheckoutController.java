package com.revature.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.Orders;
import com.revature.ecommerce.repository.OrderRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/g-corp/checkout")
public class CheckoutController {
	 
public OrderRepository or;
	
	
	@Autowired
	public CheckoutController(OrderRepository or) {
		super();
		this.or = or;
	}



	@PostMapping("/checkout")
	public ResponseEntity<Orders> checkout(@RequestBody Orders orderDetail ) {
		Orders order = or.save(orderDetail);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	

}