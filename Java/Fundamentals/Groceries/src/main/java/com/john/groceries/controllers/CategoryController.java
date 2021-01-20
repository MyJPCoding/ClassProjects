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
import org.springframework.web.bind.annotation.RequestParam;

import com.john.groceries.models.Category;
import com.john.groceries.models.Product;
import com.john.groceries.services.CategoryService;
import com.john.groceries.services.ProductService;

@Controller
public class CategoryController {
	
	private final CategoryService categoryServ;
	private final ProductService productServ;
	
	public CategoryController(CategoryService categoryServ, ProductService productServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/newCategory.jsp";
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCategory(
			@Valid @ModelAttribute("category") Category category, 
			BindingResult result) {
		
		if (result.hasErrors()) {
			return "/categories/newCategory.jsp";
		} else {
			categoryServ.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
//	@RequestMapping("/createError")
//    public String flashMessages(RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("error", "A test error!");
//        return "redirect:/categories/new";
//    }
	
	@RequestMapping("/categories/{id}")
	public String showCategory(
			@PathVariable("id") Long id, Model model) {
		
		Category newcategory = categoryServ.findCategory(id);
		model.addAttribute("category", newcategory);
		List<Product> products = productServ.allProduct();
		model.addAttribute("products", products);
		
		return "/categories/showCategory.jsp";
		
	}
	
	@RequestMapping(value="/addProductToCategory", method=RequestMethod.POST)
	public String addProductToCategory(@RequestParam(value="product_IDENTIFICATION") Long product_id, @RequestParam(value="category_id") Long category_id) {
		Category category = categoryServ.findCategory(category_id);
		Product product = productServ.findProduct(product_id);
		category.addProducts(product);
		categoryServ.Save(category);
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Category> categories = categoryServ.allCategories();
		model.addAttribute("categories", categories);
		List<Product> products = productServ.allProduct();
		model.addAttribute("products", products);
		return "index.jsp";
	}
	

}
