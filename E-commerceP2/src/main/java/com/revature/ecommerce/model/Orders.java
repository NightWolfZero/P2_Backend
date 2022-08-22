package com.revature.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "ordered_product")
	private String orderedProduct;
	private int price;
	private int userID;
	
	
}
