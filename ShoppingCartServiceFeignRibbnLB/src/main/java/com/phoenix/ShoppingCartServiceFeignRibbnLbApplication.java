package com.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShoppingCartServiceFeignRibbnLbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartServiceFeignRibbnLbApplication.class, args);
	}

}
