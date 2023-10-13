package com.mundoinformatico.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mundoinformatico.modelo.UbicacionDat;
import com.mundoinformatico.repositorio.ActivoRepositorio;
import com.mundoinformatico.repositorio.UbicacionRepositorio;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://localhost:4200/")
//@CrossOrigin(origins="http://desica.gestion-act-fijos:4200/")
@CrossOrigin(origins = "*")  // https://www.arquitecturajava.com/spring-rest-cors-y-su-configuracion/
public class UbicacionControlador {
	
	@Autowired
	private ActivoRepositorio activoRepo;  
	
	@Autowired
	private UbicacionRepositorio ubicacionRepo; 
	
	@GetMapping("/ubicaciones")
	private List<UbicacionDat> listarUbicaciones() {
		//return ubicacionRepo.findAll();
		return ubicacionRepo.findAllByOrderByDescripcionAsc(); // Query methods. 👍
	}
	
	@GetMapping("/ubicaciones/like/{clave}")
	private List<UbicacionDat> listarUbicacionesLike( @PathVariable String clave ) {
		//System.out.println("/ubicaciones/like/{clave}. clave="+clave+"*****");
		clave="%"+clave+"%";  
		return ubicacionRepo.getUbicacionesLike(clave);   
	}
	
	//----------------------------------------------------------------------
	@GetMapping("/ubicaciones/buscar/{codigo_ubic}")
	private UbicacionDat buscarUbicacionCod( @PathVariable String codigo_ubic ) {
		Optional<UbicacionDat> o = ubicacionRepo.findById(codigo_ubic);
		if ( o.isPresent() ) {
			//System.out.println("Buscar activo id="+id+"**Encontrado***"); 
			return o.get();
		}
		return null;
	} // buscarUbicacionCod(). 
	
	// Sujeto a revision???
	// Error: org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save():
	@PostMapping("/ubicaciones")
	public UbicacionDat guardar(@RequestBody UbicacionDat ubicacion ) {
		//System.out.println("****Guardar ubicacion desde remoto*****"); 
		//System.out.println("id="+id+"*****"); 
		//System.out.println( ubicacion );  // 👉 UbicacionDat [codigoUbic=null, descripcion=OFICINA DE PRUEBA] 
		//return ResponseEntity.ok(true);   
		//ubicacion.setCodigo_ubic(id);       
		return ubicacionRepo.save(ubicacion);
		//return null;
	}
	
	// Actualizar Ubicacion en desarrollo, ...
	@PutMapping("/ubicaciones")
	public ResponseEntity<UbicacionDat> actualizarUbicacion( @RequestBody UbicacionDat detalle ) {
		//Empleado e = empleadoRepo.findById(id).orElseThrow( ()-> new ResourceNotFoundException("ATENCION: Empleado identificado con el id: '"+id+"' no registrado.") );
		//
		UbicacionDat u = null;  
		//
		//e.setNombre( detalle.getNombre() );
		//e.setApellido( detalle.getApellido() );
		//e.setEmail( detalle.getEmail() );
		//
		UbicacionDat uActualizado = ubicacionRepo.save(u);  
		//
		return ResponseEntity.ok(uActualizado);   
	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Metodo eliminar.   
	// https://github.com/ChristianRaulRamirez/Spring-Backend/blob/master/gestion-empleados-backend/src/main/java/com/gestion/empleados/controlador/EmpleadoControlador.java
	// Adaptado x el master HJPB 
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@DeleteMapping("/ubicaciones/{codigo}")
	private ResponseEntity<Map<String,Boolean>> eliminar(@PathVariable() String codigo) {
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.FALSE);
		UbicacionDat ubicacion = buscarUbicacionCod( codigo ); 
		if ( ubicacion == null ) {
			System.out.println( "No existe la Ubicacion con el Codigo ubic = " + codigo);  
		} else {
			if ( activoRepo.getActivoPorCodigoUbic(codigo).size() <= 0 ) {
				System.out.println("ATENCION!: No hay activos con Ubic='"+codigo+" - procede la eliminacion.");
				ubicacionRepo.delete(ubicacion);    
				respuesta.put("eliminar",Boolean.TRUE);
			} else {
				System.out.println("ATENCION!: *HAY* activos con Ubic='"+codigo+"'");	
			}
		}
		return ResponseEntity.ok(respuesta);
    }  // org.springframework.http.ResponseEntity<Map<String, Boolean>>();    
	
}
