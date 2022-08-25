package com.revature.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.repository.CustomerRepository;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/g-corp")

public class MainController {
	
	private CustomerRepository cr;
	
	
	@Autowired
	public MainController(CustomerRepository cr) {
		super();
		this.cr = cr;
	}

	@RequestMapping("/main")
	public String showMain() {
		return "main";
	}
	
	@PostMapping("/login")
	public ResponseEntity<Customer> loginUser(@RequestBody Customer customer, HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		Customer customerObj = cr.findByUsername(customer.getUsername());
		if(customerObj.getPassword().equals(customer.getPassword())) {
			session.setAttribute("session_customerId", customerObj.getId());
			return ResponseEntity.ok(customerObj);
		}
		return (ResponseEntity<Customer>) ResponseEntity.notFound();
	}
	
	@PostMapping("/register")
	public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) {
		return ResponseEntity.ok(cr.save(customer));
	}
}