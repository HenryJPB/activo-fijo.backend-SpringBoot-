package com.mundoinformatico.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="adicion_dat")
public class AdicionDat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  
	
	/*  Sujeto a Revision ?????? 
	@OneToOne
	@JoinColumn(name = "codigo_activo")
	private ActivoDat activoDat;
	*/  
	@Column(length = 15)
	private String codigo_activo;  
	
	private Date fecha;  
	
	private String descripcion;
	
	private Integer vida_util; 
	
	private Float   valor_adicion;  

	public AdicionDat() {
		super();
	}

	public AdicionDat(Integer id, String codigo_activo, Date fecha, String descripcion, Integer vida_util,
			Float valor_adicion) {
		super();
		this.id = id;
		this.codigo_activo = codigo_activo;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.vida_util = vida_util;
		this.valor_adicion = valor_adicion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo_activo() {
		return codigo_activo;
	}

	public void setCodigo_activo(String codigo_activo) {
		this.codigo_activo = codigo_activo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getVida_util() {
		return vida_util;
	}

	public void setVida_util(Integer vida_util) {
		this.vida_util = vida_util;
	}

	public Float getValor_adicion() {
		return valor_adicion;
	}

	public void setValor_adicion(Float valor_adicion) {
		this.valor_adicion = valor_adicion;
	}

	@Override
	public String toString() {
		return "AdicionDat [id=" + id + ", codigo_activo=" + codigo_activo + ", fecha=" + fecha + ", descripcion="
				+ descripcion + ", vida_util=" + vida_util + ", valor_adicion=" + valor_adicion + "]";
	}
	
}
