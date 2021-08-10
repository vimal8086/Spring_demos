package com.phoenix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.entities.Product;
import com.phoenix.entities.User;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository prodRepo;

	@Override
	public Product findByName(String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> op = prodRepo.findById(name);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			throw new ProductNotFoundException("Product Not Found: "+name);
		}
	}

	@Override
	public Product findByBrand(String brand) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> op = prodRepo.findById(brand);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			throw new ProductNotFoundException("Product Not Found: "+ brand);
		}
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return prodRepo.findAll();
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		prodRepo.save(product);
	}

	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> op =prodRepo.findById(product.getName());
		if(op.isPresent())
		{
			prodRepo.save(product);
		}
		else
		{
			System.out.println("Product not Found  !! Sorry");
		}
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> op =prodRepo.findById(product.getName());
		if(op.isPresent())
		{
			prodRepo.delete(product);
		}
		else
		{
			System.out.println("Product not Found to delete !! Sorry");
		}
		
	}

}
