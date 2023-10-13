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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mundoinformatico.modelo.ActivoDat;
import com.mundoinformatico.modelo.UbicacionDat;
import com.mundoinformatico.repositorio.ActivoRepositorio;
import com.mundoinformatico.repositorio.AdicionRepositorio;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins="http://localhost:4200/")
//@CrossOrigin(origins="http://desica.gestion-act-fijos:4200/") 
@CrossOrigin(origins = "*")  // https://www.arquitecturajava.com/spring-rest-cors-y-su-configuracion/ 
public class ActivoControlador {
	
	@Autowired
	private ActivoRepositorio activoRepo; 
	
	@Autowired
	private AdicionRepositorio adicionRepo;   
	
	@GetMapping("/activos")
	//http://localhost:8090/activos/listar 
	// http://desica.gestion-act-fijos:8090/api/activos (ejemplo)   
	//@RequestMapping (value="/listar", method = RequestMethod. GET)
	private List<ActivoDat> listarActivos() {
		// return activoRepo.findAll( sortByDescripcionAsc() );   // Sujeto a revision!!
		return activoRepo.findAllByOrderByDescripcionAsc();       // Check repositorio.   
	} 
	
	//------------------------------------------------------------------------------
	@GetMapping("/activos/like/{clave}") 
	private List<ActivoDat> listarActivosLike( @PathVariable String clave  ) {
		//System.out.println("Aquica en 'listarActivosLike()'. Clave="+clave+"********");
		clave = "%"+clave+"%";  
		return activoRepo.getActivosLike(clave);  
	}
	
	//-----------------------------------------------------------------------
	// Utilizaremos un @RequestBody - siginifica q los Clientes
	// pueden enviar solicitud de servicio en formato 'json' dentro del cuerpo
	// de mi pagina 'html' .
	// Check: // Check: https://www.youtube.com/watch?v=o_HV_FCs-Z0
	// NOTA: '@RequestBody' permite leer el registro en formato JSon (Revisar!!!!). 
	//-----------------------------------------------------------------------
	@PostMapping("/activos/{codigo_ubic}")
	private ActivoDat guardarActivo( @PathVariable("codigo_ubic") String codigo_ubic, @RequestBody ActivoDat activo  ) {
	//public ActivoDat guardarActivo() {
		//System.out.println(".........guardar activo convocado...."); 
		//System.out.println( activo );
		//return null;
		//activo.setUbicacionDat(new UbicacionDat("ADMINISTRACION","SALA DE CONFERENCIA"));  // Probando,.... 
		//System.out.println( codigo_ubic );
		activo.setUbicacionDat(new UbicacionDat(codigo_ubic,"") ); 
		//System.out.println( activo );
		return activoRepo.save(activo);
		//return null;  
	}
	
	//-----------------------------------------------------------------------------
	@GetMapping("/activos/buscarPorId/{id}")
	private ActivoDat buscarActivoId( @PathVariable Integer id ) {
		Optional<ActivoDat> o = activoRepo.findById(id);
		if ( o.isPresent() ) {
			//System.out.println("Buscar activo id="+id+"**Encontrado***"); 
			return o.get();
		}
		return null;
	} // buscarActivo().  
	
	//-----------------------------------------------------------------------------
	@GetMapping("/activos/buscarPorCodigo/{codigo_activo}")
	private ActivoDat buscarActivoCodigoActivo( @PathVariable String codigo_activo ) {
		return activoRepo.getActivoPorCodigoActivo(codigo_activo);  
	} // buscarActivo().  

	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// Metodo eliminar.   
	// https://github.com/ChristianRaulRamirez/Spring-Backend/blob/master/gestion-empleados-backend/src/main/java/com/gestion/empleados/controlador/EmpleadoControlador.java
	// Adaptado x el master HJPB 
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@DeleteMapping("/activos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminar(@PathVariable Integer id) {
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.FALSE);
		ActivoDat activo = buscarActivoId( id );
		if ( activo == null ) {
			System.out.println( "No existe el Activo con el ID : " + id);  
		} else {
			if ( adicionRepo.getTodosByCodActivoEquals( activo.getCodigo_activo() ).size() <= 0 ) {
				activoRepo.delete(activo);  
			    respuesta.put("eliminar",Boolean.TRUE);
			} else {
				System.out.println("Eliminacion *NO* procede porque este activo posee Adiciones / Mejoras."); 
			} // if-else 	
		}
		return ResponseEntity.ok(respuesta);
    }  // org.springframework.http.ResponseEntity<Map<String, Boolean>>();    

}
