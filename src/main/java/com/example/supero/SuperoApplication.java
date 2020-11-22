package com.example.supero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.example.supero.entity"})
@ComponentScan(basePackages = {"com.example.supero"})
@EnableJpaRepositories(basePackages = {"com.example.supero.repository"},repositoryImplementationPostfix = "Impl")
@SpringBootApplication
public class SuperoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperoApplication.class, args);
	}

}
