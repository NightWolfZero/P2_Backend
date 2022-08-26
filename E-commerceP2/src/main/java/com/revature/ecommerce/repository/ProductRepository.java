package com.revature.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.ecommerce.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{

	public Optional<Products> findBypId(Integer pId);
	
	public Optional<Products> findByptitleContainingIgnoreCase(String ptitle);
}
