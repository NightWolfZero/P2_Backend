package com.revature.ecommerce.controller;

import com.revature.ecommerce.exception.ResourceNotFoundException;
import com.revature.ecommerce.model.Cart;
import com.revature.ecommerce.model.Console;
import com.revature.ecommerce.model.Customer;
import com.revature.ecommerce.model.Transaction;
import com.revature.ecommerce.repository.CartRepository;
import com.revature.ecommerce.repository.ConsoleRepository;
import com.revature.ecommerce.repository.CustomerRepository;
import com.revature.ecommerce.repository.TransactionRepository;
import com.revature.ecommerce.service.PurchaseService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/g-corp")
public class PurchaseController {

	CartRepository cartRepository;
	ConsoleRepository consoleRepository;
	TransactionRepository transactionRepository;
	CustomerRepository customerRepository;

	
	@Autowired
	public PurchaseController(CartRepository cartRepository, ConsoleRepository consoleRepository,
			TransactionRepository transactionRepository, CustomerRepository customerRepository) {
		super();
		this.cartRepository = cartRepository;
		this.consoleRepository = consoleRepository;
		this.transactionRepository = transactionRepository;
		this.customerRepository = customerRepository;
	}

	@RequestMapping("/cart")
	public ResponseEntity<Cart> getCurrentCart(@RequestBody Customer customer) {
		Cart currentCart = cartRepository.findByCustomerId(customer.getId())
				.orElse(new Cart(customer));

		return ResponseEntity.ok(currentCart);

	}

	@RequestMapping("/checkout")
	public ResponseEntity<Cart> checkoutWithCart(@RequestBody Cart cart) throws Exception {

		return ResponseEntity.ok(cart);

	}

	@PostMapping("/console/{title}/addtocart")
	public ResponseEntity<Cart> addConsoleToCart(@PathVariable(value = "title") String consoleTitle,
			@RequestBody Customer customer) throws ResourceNotFoundException {
		Console console = consoleRepository.findByptitleContainingIgnoreCase(consoleTitle).orElseThrow(() -> new ResourceNotFoundException("No Console by that Title Found"));
		
		return ResponseEntity.ok(addOrRemoveItem(customer, console, 1));
	}

	@PostMapping("/console/{title}/removefromcart")
	public ResponseEntity<Cart> removeConsoleFromCart(@PathVariable(value = "title") String consoleTitle,
			@RequestBody Customer customer) throws ResourceNotFoundException {
		Console console = consoleRepository.findByptitleContainingIgnoreCase(consoleTitle).orElseThrow(() -> new ResourceNotFoundException("No Console by that Title Found"));
		return ResponseEntity.ok(addOrRemoveItem(customer, console, -1));
	}

	


	@Transactional
	private Cart addOrRemoveItem(Customer customer, Console console, int change) {
		Cart currentCart = cartRepository.findByCustomerId(customer.getId())
				.orElse(new Cart(customer));
		
		List<Transaction> allTransactionsForCart = transactionRepository
				.findAllById_CartNum(currentCart.getCartNum());
		boolean success = false;

		for(Transaction t:allTransactionsForCart) {
			if (t.getId().getPId() == console.getPId()) {
				t.setQuantity(t.getQuantity() + change);
				currentCart.setTotalPrice((float) (currentCart.getTotalPrice()-(console.getPPrice()*change)));
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