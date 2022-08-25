package com.revature.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
@Table(name="products")
@EqualsAndHashCode
@Component
public class Products implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pId")
	private Integer pId;
	
	@Column(name="ptitle")
	private String ptitle;
	@Column(name="pdescription")
	private String pDescription;
	@Column(name="pname")
	private String pName;
	@Column(name="price")
	private String pPrice;
	
	public Products(String ptitle, String pDescription, String pName, String pPrice) {
		super();
		this.ptitle = ptitle;
		this.pDescription = pDescription;
		this.pName = pName;
		this.pPrice = pPrice;
	}
	
	
	
	
	
	
	

}
