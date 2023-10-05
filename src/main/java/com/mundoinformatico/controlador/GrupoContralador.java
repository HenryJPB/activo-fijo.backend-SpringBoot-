package com.mundoinformatico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mundoinformatico.modelo.GrupoDat;
import com.mundoinformatico.repositorio.GrupoRepositorio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class GrupoContralador {
	
	@Autowired
	private GrupoRepositorio grupoRepo;  
	
	@GetMapping("/grupo")
	private List<GrupoDat> getGrupoActivos() {
		return grupoRepo.findAll();   
	}
	
}
