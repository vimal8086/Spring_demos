package com.phoenix.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.phoenix.di.performers.Performer;

@SpringBootApplication
public class DependencyInjectionUsingGradleApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionUsingGradleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("Hello World");
		Performer p=context.getBean("Pyare_Mohan", Performer.class);
		p.perform();
		
		
	}

}
