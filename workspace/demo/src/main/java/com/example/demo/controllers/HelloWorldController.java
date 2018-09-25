package com.example.demo.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.modelo.Persona;

@Controller
@RequestMapping(path="/HolaMundo")
public class HelloWorldController {

	// /saludar/HolaMundo?prefijo=Hola
	@PostMapping(path="/saludar", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Persona saludar(@RequestBody Persona persona, @RequestParam String prefijo) {
		//Invocar el negocio
		System.out.println("prefijo" + prefijo);
		return persona;
	}
	
	@RequestMapping(path="/despedir/{nombre}", method=RequestMethod.GET)
	public @ResponseBody String despedir(@PathVariable String nombre) {
		return "Adios " + nombre;
	}
	
}
