package com.phoenix.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

/*
 * @Author vimal.makwana@stltech.in
 * @version 1.0
 * @creation date 29-07-01
 * @copyrght strelite techlongy ltd..
 */

public class Product1 implements Persistable<Integer>{
	
	@Id
	private int id;
	private String name;
	private String brand;
	private float price;
	
	@Transient
	private boolean isInsert;
	
	public Product1() {
		// TODO Auto-generated constructor stub
	}

	public Product1(int id, String name, String brand, float price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	/*
	 * public int getId() { return id; }
	 */

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	//Persistable Method Implements
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isInsert;
	}

	public boolean isInsert() {
		return isInsert;
	}
	
	//User Define selected Method
	public void setInsert(boolean isInsert) {
		this.isInsert = isInsert;
	}
	
	

}
