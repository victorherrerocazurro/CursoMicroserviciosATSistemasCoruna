package com.ejemplo.arquitectura.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HolaMundoClienteController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String home() {

		/*
		 * restTemplate.getInterceptors().add( new BasicAuthorizationInterceptor("user",
		 * "passwordholamundo"));
		 */

		// Conexion con el servicio hola mundo a traves de Eureka, con el identificador
		// con el que el servicio se regitra en Eureka
		ResponseEntity<String> respuesta = restTemplate.exchange("http://holamundo", HttpMethod.GET, null, String.class,
				new Object[] {});
		return respuesta.getBody() + " desde el microservicio cliente";

	}
}
