package com.revature.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.ecommerce.model.Console;

public interface ConsoleRepository extends JpaRepository<Console, Integer>{

	public Optional<Console> findByptitleContainingIgnoreCase(String ptitle);
}
