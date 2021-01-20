package com.john.groceries.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.john.groceries.models.Product;
import com.john.groceries.repositories.ProductRepo;

@Service
public class ProductService {
	
	private final ProductRepo productRepo;
	
	
	public ProductService(ProductRepo productRepo) {
		
		
		this.productRepo = productRepo;
	}
	
	public List<Product> allProduct(){
		return productRepo.findAll();
	}
	
	public Product createProduct(Product c) {
		return productRepo.save(c);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	


}
