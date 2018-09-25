package com.example.demo;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	@Autowired
	private RestTemplate template;

	@GetMapping("/invocar")
	public String invocacionAServicioRemoto() {
		
		//Empleamos el framework de RestTemplate
		Map<String, String> mapa = new HashMap<>();
		
		mapa.put("saludo", "Hola");
		
		ResponseEntity<Cliente> responseEntity = template.postForEntity("http://localhost:8480/HolaMundo/saludar?prefijo={saludo}", new Cliente("Victor", 12), Cliente.class, mapa);
		
		Cliente cliente = responseEntity.getBody();
		
		HttpStatus statusCode = responseEntity.getStatusCode();
		
		URI location = responseEntity.getHeaders().getLocation();
		
		System.out.println(location);
		
		return cliente.getNombre();
	}
	
}
