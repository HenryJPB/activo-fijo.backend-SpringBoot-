																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																										package com.mundoinformatico.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name="ubicacion_dat")
public class UbicacionDat {

	@Id
	private String codigo_ubic; 
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;

	public UbicacionDat() {
		super();
	}

	public UbicacionDat(String codigo_ubic, String descripcion) {
		super();
		this.codigo_ubic = codigo_ubic;
		this.descripcion = descripcion;
	}

	public String getCodigo_ubic() {
		return codigo_ubic;
	}

	public void setCodigo_ubic(String codigo_ubic) {
		this.codigo_ubic = codigo_ubic;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "UbicacionDat [codigo_ubic=" + codigo_ubic + ", descripcion=" + descripcion + "]";
	}
	
}
