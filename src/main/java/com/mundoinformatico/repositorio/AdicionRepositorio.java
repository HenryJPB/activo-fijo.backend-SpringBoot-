package com.mundoinformatico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mundoinformatico.modelo.AdicionDat;

public interface AdicionRepositorio extends JpaRepository<AdicionDat, Integer> {
	 
	// https://www.baeldung.com/spring-data-derived-queries 
	//List<AdicionDat> findAllBycodigo_activo(String codigo_activo );  // No property 'codigo' found for type 'AdicionDat' 
	// Sujeto a revision --- CodigoActivo entra en conflicto con codigo_activo. Deberia funcionar con el atributo fuese una sola palabra : SUJETO A REVISION!!!
	
	// https://docs.spring.io/spring-data/jpa/docs/2.0.0.RC2/reference/html/#jpa.query-methods
	// Autor:  HJPB. Bqto: 19-09-2023. 
	// @Query(value=" SELECT * FROM adicion_dat WHERE codigo_activo = 'HP9000' ",nativeQuery = true)   //  Error?????
	// NOTA: se desacivo el join de las tablas 'adicion_dat' -> 'activo_dat' para satisfacer el sig Query method:  
	@Query(value="SELECT * FROM adicion_dat WHERE codigo_activo = ?1",nativeQuery = true)       //
	List<AdicionDat> getTodosByCodActivosEs( String codigoActivo ); 
	 
	//List<AdicionDat> findAllByCodigo_activo(String codigo_activo );   // Error: No property 'codigoActivo' found for type 'AdicionDat'; Did you mean 'codigo_activo' 
}
