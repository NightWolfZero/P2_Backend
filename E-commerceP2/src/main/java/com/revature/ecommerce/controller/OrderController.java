package com.revature.ecommerce.controller;

import com.revature.ecommerce.model.Orders;
import com.revature.ecommerce.service.OrderService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderService os;
	
	@RequestMapping("/orders")
	public List<Orders> showAllOrders(){
		return os.getAllOrders();
	}
	
	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public void addOrder(@RequestBody Orders orders) {
		os.addOrder(orders);
	}
}
