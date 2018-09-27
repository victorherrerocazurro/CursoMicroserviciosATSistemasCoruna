package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="servicioDos")
public interface IServicioDos {
	@GetMapping("/tarea")
	void tarea();

}