package com.john.groceries.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.john.groceries.models.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{
	
	List<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	void deleteById(Long id);
}
