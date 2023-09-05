package com.mundoinformatico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mundoinformatico.modelo.UbicacionDat;

public interface UbicacionRepositorio extends JpaRepository<UbicacionDat, String> {

	@Query( value="SELECT * FROM ubicacion_dat WHERE codigo_ubic LIKE ?1 OR descripcion LIKE ?1",nativeQuery = true)   //
	List<UbicacionDat>  getUbicacionesLike( String clave ); 
	
}
