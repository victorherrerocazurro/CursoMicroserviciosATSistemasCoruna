package com.example.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo.modelo.Persona;
import com.example.demo.negocio.Negocio;
import com.example.demo.persistencia.PersonaRepository;

@RestController
@RequestMapping(path="/HolaMundo")
public class HelloWorldController {
	
	@Autowired
	//@Qualifier("negocio1")
	private Negocio negocio;
	
	@Autowired
	private PersonaRepository repository;

	// /saludar/HolaMundo?prefijo=Hola
	@PostMapping(path="/saludar", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> saludar(@Valid @RequestBody Persona persona, Errors errors, @RequestParam String prefijo, HttpSession session) throws URISyntaxException {
		
		if(!errors.hasErrors()) {
			
		}
		
		//Invocar el negocio
		
		session.setAttribute("login", "");
		
		negocio.hacerCosas();
		
		repository.save(persona);
		
		System.out.println("prefijo" + prefijo);
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://www.google.es"));
		
		return new ResponseEntity<Persona>(persona, headers, HttpStatus.OK);
	}
	
	@RequestMapping(path="/despedir/{nombre}", method=RequestMethod.GET)
	public String despedir(@PathVariable String nombre, @SessionAttribute("login") String login) {
		
		List<Persona> personas = repository.buscarPorNombre(nombre);
		
		return "Adios " + personas.get(0).getNombre();
	}
	
}
