package com.coolab.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CoolabApplication {


	public static void main(String[] args) {
		SpringApplication.run(CoolabApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}
