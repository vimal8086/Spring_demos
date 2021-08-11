package com.phoenix.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phoenix.models.CartItem;
import com.phoenix.proxy.services.ProductServiceProxy;
/*
 * @author vimal.mawana@stltech.in
 * @version 3.0
 * @creation date 4-aug-2021
 * @copyright strelite technology ltd
 * @description Shoping Cart Microservice REST API
 */
@RequestMapping("/shop-cart")
@RestController
public class ShoppingCartRestController {

	@Autowired
	private ProductServiceProxy proxy;
	
	@GetMapping("/item-id/{id}/quantity/{qty}")
	public CartItem getCartItem(@PathVariable("id")  int id,@PathVariable("qty") int quantity)
	{
		
		
		// Server MicroService URL
		
		
		//CartItem cartItem=entity.getBody();
		CartItem cartItem=proxy.getCartItemById(id);
		cartItem.setQuantity(quantity);
		
		double itemValue=cartItem.getPrice()* cartItem.getQuantity();
		cartItem.setItemValue(itemValue);
		return cartItem;
		
		
		
	}
	
}
