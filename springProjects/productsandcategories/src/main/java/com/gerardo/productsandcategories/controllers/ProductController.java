package com.gerardo.productsandcategories.controllers;

import java.util.List;

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
public class ProductController {
	
	private ProductService service;
	private CategoryService catService;
	
	public ProductController (ProductService service, CategoryService catService) {
		this.service = service;
		this.catService = catService;
	}
	
	@RequestMapping ("/products/new")
	public String addProductForm (@ModelAttribute ("product") Product product) {
		return "views/addProduct.jsp";
	}
	
	@PostMapping ("/products/new")
	public String addProduct (@Valid @ModelAttribute ("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "views/addProduct.jsp";
		} else {
			Long id = service.addProduct(product);
			return "redirect:/products/"+id;
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct (@PathVariable ("id") Long id, Model model) {
		Product existingProduct = service.getProduct(id); 
		List <Category> category_list = catService.getUnrelatedCategories(existingProduct);
		
		model.addAttribute("product", existingProduct);
		model.addAttribute("category_list", category_list);
		return "views/showProduct.jsp";
	}
	
	@PostMapping ("/products/assign_category")
	public String assignCategory (@RequestParam (value="cat_id") Long cat_id, @RequestParam (value="prod_id") Long prod_id) {
		Product product = service.getProduct(prod_id);
		Category category = catService.getCategory(cat_id);
		product.addCategory(category);
		service.addProduct(product);
		System.out.println("CATEGORY ID: "+cat_id);
		
		return "redirect:/products/"+prod_id;
	}
}
