package com.gerardo.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gerardo.productsandcategories.models.Category;
import com.gerardo.productsandcategories.models.Product;
import com.gerardo.productsandcategories.services.CategoryService;
import com.gerardo.productsandcategories.services.ProductService;

@Controller
public class CategoryController {
	
	private CategoryService service;
	private ProductService prodService;
	
	public CategoryController (CategoryService service, ProductService prodService) {
		this.service = service;
		this.prodService = prodService;
	}
	
	@RequestMapping ("/categories/new")
	public String addCategoryForm (@ModelAttribute ("category") Category category) {
		return "views/addCategory.jsp";
	}
	
	@PostMapping ("/categories/new")
	public String addCategory (@Valid @ModelAttribute ("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "views/addCategory.jsp";
		} else {
			Long id = service.addCategory(category);
			return "redirect:/categories/"+id;
		}
	}
	
	@RequestMapping ("/categories/{id}")
	public String showCategory (@PathVariable ("id") Long id, Model model) {
		Category existingCategory = service.getCategory (id);
		model.addAttribute("category", existingCategory);
		model.addAttribute("product_list", prodService.getUnrelatedProducts(existingCategory) );
		return "views/showCategory.jsp";
	}
	
	@PostMapping ("/categories/assign_product")
	public String assignProduct (@RequestParam ("prod_id") Long prod_id, @RequestParam ("cat_id") Long cat_id) {
		Category category = service.getCategory(cat_id);
		Product product = prodService.getProduct(prod_id);
		
		category.addProduct(product);
		service.addCategory(category);
		
		return "redirect:/categories/"+cat_id;
	}
}
