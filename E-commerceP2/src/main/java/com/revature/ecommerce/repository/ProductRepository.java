package com.revature.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.ecommerce.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{
	void deleteProductById(Integer id);

	Optional<Products> findProductById(Integer id);
}
