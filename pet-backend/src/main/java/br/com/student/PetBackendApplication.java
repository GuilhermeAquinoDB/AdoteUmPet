package br.com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class PetBackendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PetBackendApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Projeto Backend de Adoção de Pets")
				.version("1.0")
				.termsOfService("http://swagger.io/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
