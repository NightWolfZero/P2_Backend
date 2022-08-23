package com.revature.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.ecommerce.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{
	void deleteProductById(Integer id);

	Optional<Products> findProductById(Integer id);
}
