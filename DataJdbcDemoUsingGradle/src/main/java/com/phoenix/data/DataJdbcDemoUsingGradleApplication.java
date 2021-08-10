package com.phoenix.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product1;
import com.phoenix.data.repositores.ProductRepository;

@SpringBootApplication
public class DataJdbcDemoUsingGradleApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository ProductRepo;

	public static void main(String[] args) {
		SpringApplication.run(DataJdbcDemoUsingGradleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Product1>product1=ProductRepo.findAll();
		product1.forEach(System.out::println);
		
		// TODO Auto-generated method stub
		
	}

}
