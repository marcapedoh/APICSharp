package com.example.APICSharp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class ApicSharpApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("http://127.0.0.1:8080/swagger-ui/index.html#/")  // Spécifiez ici le chemin de votre API
				.allowedOrigins("*")  // Autoriser les requêtes provenant de ce domaine (ou "*")
				.allowedMethods("GET", "POST", "PUT", "DELETE")  // Autoriser les méthodes HTTP spécifiées
				.allowedHeaders("*");  // Autoriser tous les en-têtes
	}
	public static void main(String[] args) {
		SpringApplication.run(ApicSharpApplication.class, args);
	}

}
