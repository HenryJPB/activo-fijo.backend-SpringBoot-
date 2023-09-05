package com.mundoinformatico.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contacto_dat")
public class Contacto {

	@Id
	private Integer codigo;
	
	private String Nombre;

	public Contacto() {
		super();
	}

	public Contacto(Integer codigo, String nombre) {
		super();
		this.codigo = codigo;
		Nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Contacto [codigo=" + codigo + ", Nombre=" + Nombre + "]";
	} 
	
}
