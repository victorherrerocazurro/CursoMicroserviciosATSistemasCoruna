package com.example.demo;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class Controlador {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/")
	public String pintarMensaje(HttpServletRequest request) {
		return messageSource.getMessage("mensaje.inicio", null, RequestContextUtils.getLocale(request));
	}
	
}
