package com.angular.learning.angulareigth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com" })
@EntityScan("com.entities")
@EnableJpaRepositories("com.repositories")
public class AngulareigthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngulareigthApplication.class, args);
	}

}
