package com.tienda.entity; // ningun print ni scanner porque es una entidad

public class Cliente {
	
	private String NIT; //varchar entonces string
	private String nombre;

	
	public Cliente(String NIT, String nombre) {
		this.NIT = NIT;
		this.nombre = nombre;

	}
	//crear otro constructor
	public Cliente(String NIT){
		this.NIT=NIT;
	}

	public String getNIT() { //get y seters 
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() { // al final el to string
		return "Cliente [NIT=" + NIT + ", nombre=" + nombre + "]";
	}
	

}
