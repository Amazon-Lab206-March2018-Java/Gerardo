package com.gerardo.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.productsandcategories.models.Category;
import com.gerardo.productsandcategories.models.Product;
import com.gerardo.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository repo;
	
	public CategoryService (CategoryRepository repo) {
		this.repo = repo;
	}
	
	public Long addCategory (Category e) {
		return repo.save(e).getId();
	}
	
	public Category getCategory (Long id) {
		return repo.findById(id).get();
	}
	
	public List<Category> getAllCategories () {
		return repo.findAll();
	}
	
	public List<Category> getUnrelatedCategories (Product e) {
		return repo.findByProductsNotContaining(e);
	}
}
