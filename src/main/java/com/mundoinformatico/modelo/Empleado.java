package com.mundoinformatico.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="empleado_dat")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  
	
	@Column( length=20, nullable=false, unique=true )
	private String dni;
	
	@Column( name="nombre_completo", length=150, nullable=false )
	private String nombreCompleto; 
	
	@Column( length=150, nullable=false )
	private String email;
	
	@Column( name="fecha_nac")
	private Date fechaNac;

	public Empleado() {
		super();
	}

	public Empleado(Integer id, String dni, String nombreCompleto, String email, Date fechaNac) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.fechaNac = fechaNac;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", email=" + email
				+ ", fechaNac=" + fechaNac + "]";
	}

}
