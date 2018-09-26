package com.example.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/")
	public String pintarMensaje() {
		return messageSource.getMessage("mensaje.inicio", null, Locale.getDefault());
	}
	
}
