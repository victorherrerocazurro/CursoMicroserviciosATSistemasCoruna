package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

//No es encesaria ya que Feign es capaz de hacerlo
public class ServicioDosRestTemplate implements IServicioDos {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void tarea() {
		 restTemplate.exchange("http://holamundo", HttpMethod.GET, null, String.class, new Object[] {});
	}

}
