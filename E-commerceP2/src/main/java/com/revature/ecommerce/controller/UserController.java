package com.revature.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.exception.ResourceNotFoundException;
import com.revature.ecommerce.model.Users;
import com.revature.ecommerce.repository.UserRepository;
import com.revature.ecommerce.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/g-corp")
public class UserController {

	private UserRepository ur;
	private UserService us;
	public HttpServletRequest req;
	public HttpSession session;
	public static String username;
	private UserRepository userRepository;
	
	
	@Autowired
	public UserController(UserRepository ur, UserService us) {
		super();
		this.ur = ur;
		this.us = us;
	}

	
	@PostMapping("/user")
	public Users createUser(@RequestBody Users user) {
		return ur.save(user);
	}
	
	@PostMapping("/user")
	public Users setUser(@RequestBody Users user) {
		return ur.save(user);
	}

	@PostMapping("/user")
	public void addCustomer(@RequestBody Users user) {
		ur.save(user);
	}


	
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable(value="id") Integer id, @RequestBody Users user) throws Exception{
		Users u = ur.findById(id).orElseThrow(()->new Exception("unable to Update your Users Profile for user number: " + id));
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setBillingAddress(user.getBillingAddress());
		u.setShippingAddress(user.getShippingAddress());
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		u.setPhonenumber(user.getPhonenumber());
		
		Users updatedUser = ur.save(u);
		return ResponseEntity.ok().body(updatedUser);
	}

	@GetMapping("/users/{id}") //PathVariable value for Angular name I believe
	public ResponseEntity<Users> getUserById(@PathVariable(value = "user_id") Integer userId) throws ResourceNotFoundException {
		Users user = ur.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/user/username/{username}") //PathVariable value for Angular name I believe
	public ResponseEntity<Users> getUsersByUsername(@PathVariable(value="uname")String uname){
		Users user = ur.findByUsername(username);
		return ResponseEntity.ok().body(user);
	}
	
	 @GetMapping("/login") //Same with RequestParam
	    public ResponseEntity<Users> login(@RequestParam String uname, @RequestParam String pass) {
			Users user=null;
			if(us.login(uname, pass)) {
				user = us.getUserByUsername(uname);
				username = uname; //whatever the username is in angular
				
			}
	        return new ResponseEntity<>(user,HttpStatus.OK);
	        
	    }
		
		@PostMapping("/register")
		public ResponseEntity<Users> registerUser(@RequestBody Users user) {
			return ResponseEntity.ok(ur.save(user));
		}
		
		@GetMapping("/profile")
		public ResponseEntity<Users> getUserByUsername(){
		Users user= us.getUserByUsername(username);
		return new ResponseEntity<>(user,HttpStatus.OK);
		}
}
