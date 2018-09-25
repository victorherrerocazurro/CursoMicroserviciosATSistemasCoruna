package com.example.demo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	public List<Persona> findByNombre(String nombre);
	
	@Query("from Persona p where p.nombre= :nombre")
	public List<Persona> buscarPorNombre(@Param("nombre") String nombre);
	
}
