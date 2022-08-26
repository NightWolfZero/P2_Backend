package com.revature.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

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
@Table(name="orders")
@EqualsAndHashCode
@Component
public class Orders implements Serializable{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ordered_product")
	private String orderedProduct;
	@Column(name = "price")
	private float price;
	
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "id")
	private Customer customer;
	
	public Orders(Customer customer) {
		super();
		this.customer = customer;
	}
}
