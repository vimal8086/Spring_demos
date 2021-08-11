package com.phoenix.proxy.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phoenix.models.CartItem;

@FeignClient(name="product-service",url="localhost:8181")
public interface ProductServiceProxy {
	
	@GetMapping("/products/{id}")
	CartItem getCartItemById(@PathVariable("id") int id);

}
