package com.phoenix.controller.rest;
/*
 * @Author vimal.makwana@stltech.in
 * @Version 1.0
 * @CreationDate 2-Aug-2021
 * @Copyright Sterlite technology Ltd..
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.phoenix.entities.Product;
import com.phoenix.repositories.ProductRepository;

@RequestMapping("/products")
@RestController
public class ProductRestController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productRepo.findAll();
	}
	
	@GetMapping("/{pid}")
	public Object getById(@PathVariable("pid") int id)
	{
		Optional<Product>op=productRepo.findById(id);
		if(op.isPresent())
			return op.get();
		else
			return "Sorry! Product Not Found";
		//return productRepo.findById(id).get();
	}
	
	//Insert New Product
	@PutMapping
	public String addProduct(@RequestBody Product product) 
	{
		productRepo.save(product);
		return "New Product "+ product.getId() +" Is addded succesfully!";
	}
	
	//Update Product
	@PostMapping
	public String updateProduct(@RequestBody Product product) 
	{
		Optional<Product>op=productRepo.findById(product.getId());
		if(op.isPresent()) {
			product =productRepo.save(product);
			return "product"+ product.getId() +" is Updated Succesfully";
		}
		else
			return "Sorry! Product Is Not Found";
		
	}
	
	@DeleteMapping
	public String deleteProduct(@RequestBody Product product)
	{
		Optional<Product>op=productRepo.findById(product.getId());
		if(op.isPresent()) {
			productRepo.delete(product);
			return "product"+ product.getId() +" is Delete Succesfully!";
		}
		else
			return "Sorry! Product Is Not Found";
	}	
	
	@PostMapping("/add-form")
	public RedirectView addFormData(@RequestParam("nm") String name,@RequestParam("brand") String brand,@RequestParam("price") float price)
	{
		Product p=new Product();
		p.setName(name);
		p.setBrand(brand);
		p.setPrice(price);
		p=productRepo.save(p);
		//return "Form Data With product"+p.getId()+" is Added Successfully";
		return new RedirectView("/success");
	}
	
	@GetMapping("/{nm}/{br}")
	public List<Product> getProductByNameAndBrand(@PathVariable("nm")  String name,@PathVariable("br") String brand)
	{
		return productRepo.findByNameAndBrand(name, brand);
	}
	
	@GetMapping("/success")
	public ResponseEntity<String> getSuccessMessage()
	{
		return ResponseEntity.ok("Congratulations! Product is saved Successfully");
	}
}
