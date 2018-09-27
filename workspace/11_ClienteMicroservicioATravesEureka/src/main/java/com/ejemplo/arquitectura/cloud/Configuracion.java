package com.ejemplo.arquitectura.cloud;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configuracion {

	@Bean
	//Anotacion que activa el descubrimiento de servicios en el servidor Eureka por su identificador 
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplateBuilder().setConnectTimeout(2000).build();
	}
	
}