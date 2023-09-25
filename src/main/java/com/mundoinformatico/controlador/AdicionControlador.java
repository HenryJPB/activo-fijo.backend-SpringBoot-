package com.mundoinformatico.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mundoinformatico.modelo.ActivoDat;
import com.mundoinformatico.modelo.AdicionDat;
import com.mundoinformatico.repositorio.AdicionRepositorio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class AdicionControlador {

	@Autowired
	private AdicionRepositorio adicionRepo;   
	
	@GetMapping("/adiciones/{codigo_activo}")
	private List<AdicionDat> getAdiciones( @PathVariable("codigo_activo") String codigo_activo ) { 
		//return adicionRepo.findAllBycodigo_activo(codigo_activo);  // check Query Methods.
		Sort sortByFecha = Sort.by(Sort.Direction.DESC, "fecha");
		return adicionRepo.getTodosByCodActivosEquals( codigo_activo );     
	}  // getAdiciones(). 

	@GetMapping("/adiciones/buscar/{codigo_activo}/{id}")
	private AdicionDat getAdicionByCodActivoAndId( @PathVariable("codigo_activo") String codigo_activo,  @PathVariable("id") Integer id ) {
    	return adicionRepo.getAdicionByCodigoActivoAndIdEquals(codigo_activo, id);    
	}
	
	@PostMapping("/adiciones")
	private AdicionDat guardar( @RequestBody AdicionDat adicion ) {
		System.out.println( "guardar a: " + adicion ); 
		return adicionRepo.save(adicion);
		//return null;   
	} // guardar()   
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Metodo eliminar.   
	// https://github.com/ChristianRaulRamirez/Spring-Backend/blob/master/gestion-empleados-backend/src/main/java/com/gestion/empleados/controlador/EmpleadoControlador.java
	// Adaptado x el master HJPB
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@DeleteMapping("/adiciones/{codigo_activo}/{id}") 
	private ResponseEntity<Map<String,Boolean>> eliminar( @PathVariable("codigo_activo") String codigo_activo, @PathVariable Integer id) {
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.FALSE);
		AdicionDat adicion = getAdicionByCodActivoAndId( codigo_activo, id ); 
		if ( adicion== null ) {
			System.out.println( "No existe la Adicion/Mejora con el ID : " + id);  
		} else {
			adicionRepo.delete(adicion);  
			respuesta.put("eliminar",Boolean.TRUE);
		}
		return ResponseEntity.ok(respuesta);
    }  // org.springframework.http.ResponseEntity<Map<String, Boolean>>();  
	
} // class AdicionControlador. 
