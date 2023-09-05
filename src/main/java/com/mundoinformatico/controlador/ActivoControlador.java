package com.mundoinformatico.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mundoinformatico.modelo.ActivoDat;
import com.mundoinformatico.modelo.UbicacionDat;
import com.mundoinformatico.repositorio.ActivoRepositorio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class ActivoControlador {
	
	@Autowired
	private ActivoRepositorio activoRepo;  
	
	@GetMapping("/activos")
	//http://localhost:8090/activos/listar 
	//@RequestMapping (value="/listar", method = RequestMethod. GET)
	private List<ActivoDat> listarActivos() {
		return activoRepo.findAll();    
	} 
	
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
	//-----------------------------------------------------------------------
	@PostMapping("/activos")
	public ActivoDat guardarActivo( @RequestBody ActivoDat activo  ) {
	//public ActivoDat guardarActivo() {
		System.out.println(".........guardar activo convocado...."); 
		System.out.println( activo );
		//return null;
		activo.setUbicacionDat(new UbicacionDat("ADMINISTRACION","SALA DE CONFERENCIA"));  // Probando,.... 
		System.out.println( activo );
		return activoRepo.save(activo);
	}
	
	@GetMapping("activos/buscar/{id}")
	private ActivoDat buscarActivoId( @PathVariable Integer id ) {
		Optional<ActivoDat> o = activoRepo.findById(id);
		if ( o.isPresent() ) {
			//System.out.println("Buscar activo id="+id+"**Encontrado***"); 
			return o.get();
		}
		return null;
	} // buscarActivo().  

}
