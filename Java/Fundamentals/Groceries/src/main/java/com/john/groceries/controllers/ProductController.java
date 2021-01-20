package com.john.groceries.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.john.groceries.models.Category;
import com.john.groceries.models.Product;
import com.john.groceries.services.CategoryService;
import com.john.groceries.services.ProductService;

@Controller
public class ProductController {
	
	private final CategoryService categoryServ;
	private final ProductService productServ;
	
	
	public ProductController(CategoryService categoryServ, ProductService productServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/newProduct.jsp";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/newProduct";
		} else {
			productServ.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
//	@RequestMapping("/products/{id}")
//	public String showProduct(@PathVariable("id") Long id, @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, Model model) {
//		
//		Product newproduct = productServ.findProduct(id);
//		model.addAttribute("product", newproduct);
//		List<Category> categories = categoryServ.allCategories();
//		model.addAttribute("categories", categories);
//		
//		return "/products/showProduct.jsp";
//		
//	}
//	
//	@RequestMapping(value="/addCategoryToProduct", method=RequestMethod.POST)
//	public String addCategoryToProduct(@Valid @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
//		
//		if (result.hasErrors()) {
//			return "/products/showCategory.jsp";
//		} else {
//			productServ.createCategoryProduct(categoryProduct);
//			return "redirect:/products/new";
//		}
//		
//	}
	

}
