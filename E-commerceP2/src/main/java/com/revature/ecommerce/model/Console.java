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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
@Table(name="products")
@EqualsAndHashCode
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","transactions"})
public class Console implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="p_id")
	private Integer pId;
	
	@Column(name="ptitle")
	private String ptitle;
	@Column(name="pdescription")
	private String pDescription;
	@Column(name="pname")
	private String pName;
	@Column(name="pprice")
	private double pPrice;
	
	
	public Console(String ptitle, String pDescription, String pName, double pPrice) {
		super();
		this.ptitle = ptitle;
		this.pDescription = pDescription;
		this.pName = pName;
		this.pPrice = pPrice;
	}


	@OneToMany(mappedBy = "console")
	private Set<Transaction> transactions = new HashSet<>();
	
	

	
	
	
	
	
	
	

}
