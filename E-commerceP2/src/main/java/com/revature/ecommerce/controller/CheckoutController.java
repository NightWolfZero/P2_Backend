package com.revature.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.Cart;
import com.revature.ecommerce.repository.CartRepository;


@RequestMapping("/g-corp")
@CrossOrigin(origins ="*")
@RestController
public class CheckoutController {
	 
public CartRepository or;
	
	
	@Autowired
	public CheckoutController(CartRepository or) {
		super();
		this.or = or;
	}



	@PostMapping("/checkout")
	public ResponseEntity<Cart> checkout(@RequestBody Cart orders ) {
		Cart order = or.save(orders);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	

}