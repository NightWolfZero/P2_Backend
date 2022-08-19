package com.revature.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AdminID;
    private String firstname;
    private String lastname;
    private String userName;
    private String phoneNumber;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumns({
    	@JoinColumn(name="user_id", referencedColumnName = "id"),
    	@JoinColumn(name="email", referencedColumnName="email")
    } )    
    private Users user;

	public Admin(String firstname, String lastname, String userName, String phoneNumber, Users user) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}
    
    
    
    
}
