package com.ejemplo.spring.data.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejemplo.spring.data.rest.entities.Factura;
import com.ejemplo.spring.data.rest.services.Servicio;

@RunWith(SpringRunner.class)
//Definimos un contexto para la persistencia dummy, H2
@DataJpaTest
@ContextConfiguration(classes=ConfiguracionTest.class)
public class ServiceIT {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	Servicio sut;
	
	//Datos de Prueba (Ctes)
	//No pasamos el id porque es autogenerado, y al estar insertandose 4 registros con el fichero *data.sql*, 
	//el id que le toca a este registro es 5
	Factura factura = new Factura(0, "Compra");
	
	@Test
	public void nuevoTest() {
		//Ejecutar el codigo a probar
		sut.nuevo(factura);		
		//En caso de que el SUT probado no retorne resultado, la alternativa para la validacion
		//es comprobar el estado en el que queda el entorno
		Factura resultadoObtenido = entityManager.find(Factura.class, 5l);
		//Validar
		assertEquals(factura.getId(), resultadoObtenido.getId());	
	}
}
