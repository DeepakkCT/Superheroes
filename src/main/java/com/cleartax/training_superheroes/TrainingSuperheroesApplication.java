package com.cleartax.training_superheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cleartax.training_superheroes")
public class TrainingSuperheroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingSuperheroesApplication.class, args);
	}

}
