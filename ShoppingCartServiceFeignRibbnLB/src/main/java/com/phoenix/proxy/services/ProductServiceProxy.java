package com.phoenix.proxy.services;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.phoenix.models.CartItem;
import com.phoenix.utilities.CartServiceInfo;


public interface ProductServiceProxy {
	
	@GetMapping("/products/{id}")
	CartItem getCartItemById(@PathVariable("id") int id);

	@GetMapping("/products-info/product/{id}")
	CartServiceInfo getCartServiceInfo(@PathVariable("id") int id);

}
