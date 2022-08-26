package com.revature.ecommerce.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="users")
@EqualsAndHashCode
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","carts"})
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cust_id")
	private Integer id;
	
	@Column(unique = true)
		private String username;
	
	@Column(name="password")
		private String password;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	
	
	@OneToMany(mappedBy = "customer")
	private Set<Cart> carts = new HashSet<>();


	public Customer(String username, String password, String firstName, String lastName, Set<Cart> carts) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.carts = carts;
	}
	
	
	
	
	
}





	
	
	

