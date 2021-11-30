package com.example.SimpleNoticeBoardExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SimpleNoticeBoardExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleNoticeBoardExampleApplication.class, args);

	}

}
