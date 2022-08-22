package com.revature.ecommerce.service;

import com.revature.ecommerce.model.Orders;
import com.revature.ecommerce.model.Products;
import com.revature.ecommerce.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	
	private final OrderRepository or;
	
	
	public OrderService(OrderRepository or) {
		super();
		this.or = or;
	}

	public List<Orders> getAllOrders(){
		List<Orders> getAllOrders = new ArrayList<>();
		or.findAll().forEach(getAllOrders::add);
		
		return getAllOrders;
	}
	
	public void addOrder(Orders order) {
		or.save(order);
	}
	
	
	
	public void deleteOrder(Integer ordered_product) {
		or.deleteById(ordered_product);
	}
	
	
	public Orders updateOrder(Orders order) {
		return or.save(order);
	}
	
	
	

}
