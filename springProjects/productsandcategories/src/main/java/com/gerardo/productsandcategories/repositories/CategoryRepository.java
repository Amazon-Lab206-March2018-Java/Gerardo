package com.gerardo.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.productsandcategories.models.Category;
import com.gerardo.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long>{
	List<Category> findAll();
	List<Category> findByProductsNotContaining (Product e);
}