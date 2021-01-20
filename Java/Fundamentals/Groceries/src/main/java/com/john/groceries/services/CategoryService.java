package com.john.groceries.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.john.groceries.models.Category;

import com.john.groceries.repositories.CategoryRepo;

@Service
public class CategoryService {
	
	private final CategoryRepo categoryRepo;
	
	
	
	public CategoryService(CategoryRepo categoryRepo) {
		
		this.categoryRepo = categoryRepo;
	}
	
	public List<Category> allCategories(){
		return categoryRepo.findAll();
	}
	
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	public void Save(Category category) {
		categoryRepo.save(category);
	}

}
