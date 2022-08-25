package com.revature.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.repository.CustomerRepository;



@RestController
@RequestMapping("/g-corp")
@CrossOrigin(origins ="*")
public class CustomerController {

	public HttpServletRequest req;
	public HttpSession session;
	private CustomerRepository cr;
	public static String uname;
	
	@Autowired
	public CustomerController(CustomerRepository cr) {
		super();
		this.cr = cr;
	}
	
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value="id")Integer id) throws Exception {
		Customer customer = cr.findById(id).orElseThrow(()->new Exception("Unable to find Customer number: " + id));
		return ResponseEntity.ok().body(customer);
	}
	
	@GetMapping("/customer/username/{username}")
	public ResponseEntity<Customer> getCustomerByUsername(@PathVariable(value="username")String username){
		Customer customer = cr.findByUsername(username);
		return ResponseEntity.ok().body(customer);
	}
	
	@PostMapping("/customer")
	public Customer setCustomer(@RequestBody Customer customer) {
		return cr.save(customer);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value="id") Integer id, @RequestBody Customer customer) throws Exception{
		Customer c = cr.findById(id).orElseThrow(()->new Exception("unable to Update your Customer Profile for customer number: " + id));
		c.setUsername(customer.getUsername());
		c.setPassword(customer.getPassword());
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		
		Customer updatedCust = cr.save(c);
		return ResponseEntity.ok().body(updatedCust);
	}
}
	 