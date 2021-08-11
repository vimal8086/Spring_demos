package com.phoenix.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.phoenix.models.CartItem;
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

	@GetMapping("/item-id/{id}/quantity/{qty}")
	public CartItem getCartItem(@PathVariable("id")  int id,@PathVariable("qty") int quantity)
	{
		
		 // @Autowired RestTemplate restTemplate;
		 
		// Server MicroService URL
		String serverUrl="http://localhost:8181/products/{id}";
		
		Map<String,Integer> urlVariables=new HashMap<>();
		urlVariables.put("id", id);
		
		
		RestTemplate restTemplate=new RestTemplate();
		
		//Caling server MicroServices using RestTempate
		ResponseEntity<CartItem>entity=
				restTemplate.getForEntity(serverUrl, CartItem.class, urlVariables);
		//fatcheing response Body
		CartItem cartItem=entity.getBody();
		
		cartItem.setQuantity(quantity);
		
		double itemValue=cartItem.getPrice()* cartItem.getQuantity();
		cartItem.setItemValue(itemValue);
		return cartItem;
		
		
		
	}
	
}
