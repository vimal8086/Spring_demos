package com.phoenix.services;

import java.util.List;

import com.phoenix.entities.Product;
import com.phoenix.entities.User;
import com.phoenix.exceptions.ProductNotFoundException;

public interface ProductService {

	Product findByName(String name) throws ProductNotFoundException;
	Product findByBrand(String brand) throws ProductNotFoundException;
	List<Product> findAllProducts();
	void add(Product product);
	void edit(Product product);
	void delete(Product product);
	
	
}
