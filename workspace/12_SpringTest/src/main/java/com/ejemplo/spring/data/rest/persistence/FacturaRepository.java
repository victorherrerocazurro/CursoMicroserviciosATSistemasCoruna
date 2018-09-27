package com.ejemplo.spring.data.rest.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ejemplo.spring.data.rest.entities.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

	List<Factura> findByConcepto(String concepto);
	
	@Query(value="select f from Factura f where f.concepto = :concepto")
	List<Factura> consultarPorConcepto(@Param("concepto") String concepto);
	
	Page<Factura> findByConceptoStartsWith(@Param("concepto") String concepto, Pageable p);
	
}
