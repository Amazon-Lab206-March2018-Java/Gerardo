package com.gerardo.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerardo.productsandcategories.models.Category;
import com.gerardo.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{
	List<Product> findAll();
	List<Product> findByCategoriesNotContaining (Category e);
}