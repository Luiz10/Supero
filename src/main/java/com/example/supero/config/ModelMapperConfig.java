package com.example.supero.config;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig implements Serializable{

	private static final long serialVersionUID = 1L;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
