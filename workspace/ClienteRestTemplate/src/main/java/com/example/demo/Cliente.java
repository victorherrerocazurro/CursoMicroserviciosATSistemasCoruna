package com.example.demo;

public class Cliente {
	private String nombre;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Cliente(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
}
