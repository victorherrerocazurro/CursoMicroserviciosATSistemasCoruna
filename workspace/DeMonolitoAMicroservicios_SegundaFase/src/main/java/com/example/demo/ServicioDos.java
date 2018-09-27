package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioDos implements IServicioDos {

	@Override
	@GetMapping("/tarea")
	public void tarea() {
		// TODO Auto-generated method stub

	}

}
