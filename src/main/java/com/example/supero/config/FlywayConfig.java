package com.example.supero.config;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

	@Bean
	public Flyway flyway() {
		return Flyway.configure().dataSource("jdbc:oracle:thin:@localhost:1521:xe", "neto", "neto").load();
	}
}
