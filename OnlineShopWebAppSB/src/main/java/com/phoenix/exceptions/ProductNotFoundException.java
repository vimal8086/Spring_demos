package com.phoenix.exceptions;

public class ProductNotFoundException extends Exception {

	
	private String message;

	public ProductNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProductNotFoundException [message=" + message + "]";
	}
	
	
}
