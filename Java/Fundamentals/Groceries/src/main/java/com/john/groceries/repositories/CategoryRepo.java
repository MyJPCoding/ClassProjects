package com.john.groceries.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.john.groceries.models.Category;

public interface CategoryRepo extends CrudRepository <Category, Long>{
	
	List<Category> findAll();
	
	Optional<Category> findById(Long id);
	
	void deleteById(Long id);

}
