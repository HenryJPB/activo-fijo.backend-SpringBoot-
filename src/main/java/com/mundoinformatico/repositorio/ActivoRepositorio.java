package com.mundoinformatico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mundoinformatico.modelo.ActivoDat;

public interface ActivoRepositorio extends JpaRepository<ActivoDat, Integer> {
	
	//List<ActivoDat> findByCodigo_activoLike( String clave ); // Error, check for 'codigoActivo' y/o 'codigo_activo'
	
	// Error 👇
	// List<ActivoDat> findByCodigoActivoLikeOrFindByDescripcionLike( String clave1, String clave );    // Error,..!!!

	// https://docs.spring.io/spring-data/jpa/docs/2.0.0.RC2/reference/html/#jpa.query-methods 
	@Query(value="SELECT * FROM activo_dat WHERE codigo_activo LIKE ?1 OR descripcion LIKE ?1",nativeQuery = true)   // 
	List<ActivoDat> getActivosLike( String clave ); 
	
	List<ActivoDat> findAllByOrderByDescripcionAsc(); // Query methods. 👍
	
	@Query(value="SELECT * FROM activo_dat WHERE codigo_activo = ?",nativeQuery = true)   // 
	ActivoDat getActivoPorCodigoActivo( String codigo_activo ); 
	
	@Query(value="SELECT * FROM activo_dat WHERE codigo_ubic = ?",nativeQuery = true)   // 
	List<ActivoDat> getActivoPorCodigoUbic( String codigo_ubic );
	
	@Query(value="SELECT Min( id ) FROM activo_dat",nativeQuery = true) 
	Integer getPrimero();
	
	@Query(value="SELECT id FROM activo_dat WHERE id < ?1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
	Integer getPrevio(Integer previo );   	

	@Query(value="SELECT id FROM activo_dat WHERE id > ?1 ORDER BY id ASC LIMIT 1",nativeQuery = true)
	Integer getProximo( Integer proximo ); 
	
	@Query(value="SELECT Max( id ) FROM activo_dat",nativeQuery = true) 
	Integer getFinal();
	
}
