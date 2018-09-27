package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class ServicioUno {

	@Autowired
	private IServicioDos servicioDos;
	
	public void tarea() {
		servicioDos.tarea();
	}
	
}
