package com.revature.ecommerce.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","console", "cart"})
public class Transaction {
	
	@EmbeddedId
	private TransactionId id;
	
	@ManyToOne
	@MapsId("pId")
	@JoinColumn(name = "p_id")
	private Console console;
	
	@ManyToOne
	@MapsId("cartNum")
	@JoinColumn(name = "cart_num")
	private Cart cart;
	
	private Integer quantity;

	

	public Transaction(Console console, Cart cart, Integer quantity) {
		super();
		this.id = new TransactionId(console.getPId(), cart.getCartNum());
		this.quantity = quantity;
	}


	
	

	

}