package com.mundoinformatico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return adicionRepo.getTodosByCodActivosEs( codigo_activo  );     
	}  // getAdiciones(). 

} // class AdicionControlador. 
