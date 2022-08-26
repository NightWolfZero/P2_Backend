package com.revature.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
public class TransactionId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "pId")
	private Integer pId;
	
	@Column(name = "cart_num")
	private Integer cartNum;
	

}