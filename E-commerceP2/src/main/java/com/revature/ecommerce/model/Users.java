package com.revature.ecommerce.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.repository.query.Param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String email;
	private String username;
	private String password;
	private String role;
	private String address;
	private boolean enabled;


	
	
public Users(int user_id, String firstname, String lastname, String phonenumber, String email, String username,
			String password, String role, boolean enabled, ShippingAddress shippingAddress,
			BillingAddress billingAddress, Users user) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.user = user;
	}

	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private Users user;

}
	
	
	

