package com.gerardo.productsandcategories.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gerardo.productsandcategories.models.Category;
import com.gerardo.productsandcategories.models.Product;
import com.gerardo.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository repo;
	
	public ProductService (ProductRepository repo, CategoryService catService) {
		this.repo = repo;
	}
	
	public Long addProduct (Product e) {
		return repo.save(e).getId();
	}
	
	public List<Product> getAllProducts () {
		return repo.findAll();
	}
	
	public Product getProduct (Long id) {
		return repo.findById(id).get();
	}
	
	public List<Product> getUnrelatedProducts (Category e) {
		return repo.findByCategoriesNotContaining (e);
	}
}
