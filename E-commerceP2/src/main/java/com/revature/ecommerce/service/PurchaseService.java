package com.revature.ecommerce.service;

import com.revature.ecommerce.model.Cart;
import com.revature.ecommerce.model.Console;
import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.model.Transaction;
import com.revature.ecommerce.repository.CartRepository;
import com.revature.ecommerce.repository.ConsoleRepository;
import com.revature.ecommerce.repository.CustomerRepository;
import com.revature.ecommerce.repository.TransactionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {
	
	CartRepository cartRepository;
	ConsoleRepository consoleRepository;
	TransactionRepository transactionRepository;
	CustomerRepository customerRepository;
	
	@Autowired
	public PurchaseService(CartRepository cartRepository, ConsoleRepository consoleRepository,
			TransactionRepository transactionRepository, CustomerRepository customerRepository) {
		super();
		this.cartRepository = cartRepository;
		this.consoleRepository = consoleRepository;
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;

	}
	

	@Transactional
	public Cart addOrRemoveItem(Customer customer, Console console, Integer change) {
		Cart currentCart = cartRepository.findByCustomerId(customer.getId())
				.orElse(new Cart(customer));
		
		List<Transaction> allTransactionsForCart = transactionRepository
				.findAllById_CartNum(currentCart.getCartNum());
		boolean success = false;

		for(Transaction t:allTransactionsForCart) {
			if (t.getId().getPId().equals(console.getPId())) {
				t.setQuantity(t.getQuantity() + change);
				currentCart.setTotalPrice((float) (currentCart.getTotalPrice()+(console.getPPrice()*change)));
				success = true;
		}
			if(t.getQuantity()==0) {
				transactionRepository.delete(t);
			}
			
		}
		if(!success && change>0) {
			new Transaction(console, currentCart, change);
		}
			

		return currentCart;

	}
}