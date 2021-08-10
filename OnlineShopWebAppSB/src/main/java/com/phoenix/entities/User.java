package com.phoenix.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/*
 * @Author vimal.makwana@stltech.in
 * @version 1.0
 * @creatondate 2-aug-2021
 * @copyright sterlite technology ltd..
 * 
 */
@Component
@Entity
@Table(name="login")
public class User {
	
	@Id
	private String username;
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	

}
