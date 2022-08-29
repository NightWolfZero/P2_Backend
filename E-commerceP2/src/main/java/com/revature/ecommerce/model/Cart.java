package com.revature.ecommerce.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Table(name="orders")
@EqualsAndHashCode
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","customer"})
public class Cart implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cart_num")
	private Integer cartNum;
	
	//@Column(name = "price")
	private float totalPrice;
	
	
	@OneToMany(mappedBy = "cart")
	private Set<Transaction> transactions = new HashSet<>();
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	public Cart(Customer customer) {
		super();
		this.customer = customer;
	}
}
