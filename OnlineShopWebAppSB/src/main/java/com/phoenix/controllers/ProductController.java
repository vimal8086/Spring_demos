package com.phoenix.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.phoenix.entities.Product;
import com.phoenix.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@GetMapping("/products")
	public String productValidate(Product product,HttpSession session)
	{ 
		List<Product> products = prodService.findAllProducts(); 
		if(session!= null)
		{
			session.setAttribute("products", products);
			return "Products.jsp";
		}
		else
		{
			return "Time-Out Please visit in given time frame";
		}
	}
	
	
	
	
}
