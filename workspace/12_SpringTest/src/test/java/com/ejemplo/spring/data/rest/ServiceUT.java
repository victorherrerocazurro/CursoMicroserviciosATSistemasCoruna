package com.ejemplo.spring.data.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.ejemplo.spring.data.rest.persistence.FacturaRepository;
import com.ejemplo.spring.data.rest.services.Servicio;

@RunWith(SpringRunner.class)
//Con esta opcion empleamos todo el contexto de Spring definido para la aplicacion
//@SpringBootTest
//Con esta solo empleamos los beans definidos en ConfiguracionTest, por lo que es mas ligero 
@ContextConfiguration(classes=ConfiguracionTest.class)
public class ServiceUT {
	@Autowired
	Servicio sut;
	@MockBean
	FacturaRepository repository;
	
	//Datos de Prueba (Ctes)
	Factura facturaSinId = new Factura(0, "Compra");
	Factura facturaConId = new Factura(1, "Compra");
	Factura facturaParaError = new Factura(3, "Error");
	
	//Definimos el comportamiento del Mock
	@Before
	public void init(){
		Mockito.when(repository.save(facturaSinId)).thenReturn(facturaConId);
		Mockito.when(repository.save(facturaParaError)).thenThrow(RuntimeException.class);
	}
	
	@Test
	public void nuevoTest() {
		//Ejecutar el codigo a probar
		Factura resultadoObtenido = sut.nuevo(facturaSinId);
		//resuladoObtenido es unicamente dependiente de nuestro algoritmo
		//Validar
		assertEquals(facturaConId.getId(), resultadoObtenido.getId());
	}
	
	@Test(expected=RuntimeException.class)
	public void errorTest() {
		Factura resultadoObtenido = sut.nuevo(facturaParaError);
	}
}