package com.wordpress.carledwinj.productapimongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.wordpress.carledwinj.productapimongodb"})
@SpringBootApplication
public class ProductApiMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiMongodbApplication.class, args);
	}
}
