package com.mundoinformatico.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="grupo_dat" )
public class GrupoDat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  
	
	private String descripcion;  
	
	private String cuenta_cargo; 
	
	private String cuenta_abono; 
	
	private String tipo_activo;
	
	
	public GrupoDat() {
		super();
	}

	public GrupoDat(Integer id, String descripcion, String cuenta_cargo, String cuenta_abono, String tipo_activo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.cuenta_cargo = cuenta_cargo;
		this.cuenta_abono = cuenta_abono;
		this.tipo_activo = tipo_activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCuenta_cargo() {
		return cuenta_cargo;
	}

	public void setCuenta_cargo(String cuenta_cargo) {
		this.cuenta_cargo = cuenta_cargo;
	}

	public String getCuenta_abono() {
		return cuenta_abono;
	}

	public void setCuenta_abono(String cuenta_abono) {
		this.cuenta_abono = cuenta_abono;
	}

	public String getTipo_activo() {
		return tipo_activo;
	}

	public void setTipo_activo(String tipo_activo) {
		this.tipo_activo = tipo_activo;
	}

	@Override
	public String toString() {
		return "GrupoDat [id=" + id + ", descripcion=" + descripcion + ", cuenta_cargo=" + cuenta_cargo
				+ ", cuenta_abono=" + cuenta_abono + ", tipo_activo=" + tipo_activo + "]";
	} 	

}
