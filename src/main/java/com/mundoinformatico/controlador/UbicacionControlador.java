package com.mundoinformatico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mundoInformatico.Empleado;
import com.mundoInformatico.excepciones.ResourceNotFoundException;
import com.mundoinformatico.modelo.UbicacionDat;
import com.mundoinformatico.repositorio.UbicacionRepositorio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class UbicacionControlador {
	
	@Autowired
	private UbicacionRepositorio ubicacionRepo; 
	
	@GetMapping("/ubicaciones")
	private List<UbicacionDat> listarUbicaciones() {
		return ubicacionRepo.findAll();  
	}
	
	@GetMapping("/ubicaciones/like/{clave}")
	private List<UbicacionDat> listarUbicacionesLike( @PathVariable String clave ) {
		//System.out.println("/ubicaciones/like/{clave}. clave="+clave+"*****");
		clave="%"+clave+"%";  
		return ubicacionRepo.getUbicacionesLike(clave);   
	}
	
	// Sujeto a revision???
	// Error: org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save():
	@PostMapping("/ubicaciones/{id}")
	public UbicacionDat guardarUbicacion(@PathVariable String id, @RequestBody UbicacionDat ubicacion ) {
		System.out.println("****Guardar ubicacion desde remoto*****"); 
		//System.out.println("id="+id+"*****"); 
		System.out.println( ubicacion );  // 👉 UbicacionDat [codigoUbic=null, descripcion=OFICINA DE PRUEBA] 
		//return ResponseEntity.ok(true);   
		//ubicacion.setCodigo_ubic(id);       
		//System.out.println( ubicacion );
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

}
