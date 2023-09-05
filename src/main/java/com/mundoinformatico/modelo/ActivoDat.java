package com.mundoinformatico.modelo;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activo_dat")
public class ActivoDat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  
	
	@Column(length = 15)
	private String codigo_activo;

	@Column(length = 100)
	private String descripcion;

	@OneToOne
	@JoinColumn(name = "codigo_ubic")
	private UbicacionDat ubicacionDat;

	@Lob
    private byte[] imagen;;

	@Column(name = "nro_compra")
	private String nroCompra;

	private String marca;

	private String modelo;

	private String serial;

	private Byte vida_util;

	private Float valor_inicial;

	private Float valor_rescate;

	private Float valor_libro;

	private Float depre_anual;

	private Float depre_acum;

	private String observacion;

	// Un TinyInt en mi BD MariaDB; number en mi definicion de clase TypeScript del
	// activo-fijo.frontend de mi proyecto Angular.
	private Byte desincorporado;

	//============================================================================================
	
	public ActivoDat() {
		super();
	}

	public ActivoDat(Integer id, String codigo_activo, String descripcion, UbicacionDat ubicacionDat, byte[] imagen,
			String nroCompra, String marca, String modelo, String serial, Byte vida_util, Float valor_inicial,
			Float valor_rescate, Float valor_libro, Float depre_anual, Float depre_acum, String observacion,
			Byte desincorporado) {
		super();
		this.id = id;
		this.codigo_activo = codigo_activo;
		this.descripcion = descripcion;
		this.ubicacionDat = ubicacionDat;
		this.imagen = imagen;
		this.nroCompra = nroCompra;
		this.marca = marca;
		this.modelo = modelo;
		this.serial = serial;
		this.vida_util = vida_util;
		this.valor_inicial = valor_inicial;
		this.valor_rescate = valor_rescate;
		this.valor_libro = valor_libro;
		this.depre_anual = depre_anual;
		this.depre_acum = depre_acum;
		this.observacion = observacion;
		this.desincorporado = desincorporado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UbicacionDat getUbicacionDat() {
		return ubicacionDat;
	}

	public void setUbicacionDat(UbicacionDat ubicacionDat) {
		this.ubicacionDat = ubicacionDat;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNroCompra() {
		return nroCompra;
	}

	public void setNroCompra(String nroCompra) {
		this.nroCompra = nroCompra;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Byte getVida_util() {
		return vida_util;
	}

	public void setVida_util(Byte vida_util) {
		this.vida_util = vida_util;
	}

	public Float getValor_inicial() {
		return valor_inicial;
	}

	public void setValor_inicial(Float valor_inicial) {
		this.valor_inicial = valor_inicial;
	}

	public Float getValor_rescate() {
		return valor_rescate;
	}

	public void setValor_rescate(Float valor_rescate) {
		this.valor_rescate = valor_rescate;
	}

	public Float getValor_libro() {
		return valor_libro;
	}

	public void setValor_libro(Float valor_libro) {
		this.valor_libro = valor_libro;
	}

	public Float getDepre_anual() {
		return depre_anual;
	}

	public void setDepre_anual(Float depre_anual) {
		this.depre_anual = depre_anual;
	}

	public Float getDepre_acum() {
		return depre_acum;
	}

	public void setDepre_acum(Float depre_acum) {
		this.depre_acum = depre_acum;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Byte getDesincorporado() {
		return desincorporado;
	}

	public void setDesincorporado(Byte desincorporado) {
		this.desincorporado = desincorporado;
	}

	@Override
	public String toString() {
		return "ActivoDat [id=" + id + ", codigo_activo=" + codigo_activo + ", descripcion=" + descripcion
				+ ", ubicacionDat=" + ubicacionDat + ", imagen=" + Arrays.toString(imagen) + ", nroCompra=" + nroCompra
				+ ", marca=" + marca + ", modelo=" + modelo + ", serial=" + serial + ", vida_util=" + vida_util
				+ ", valor_inicial=" + valor_inicial + ", valor_rescate=" + valor_rescate + ", valor_libro="
				+ valor_libro + ", depre_anual=" + depre_anual + ", depre_acum=" + depre_acum + ", observacion="
				+ observacion + ", desincorporado=" + desincorporado + "]";
	}
	
}
