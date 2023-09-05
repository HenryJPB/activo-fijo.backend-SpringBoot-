package com.mundoinformatico.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mundoinformatico.modelo.Empleado;
import com.mundoinformatico.repositorio.EmpleadoRepositorio;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {

	@Autowired
	private EmpleadoRepositorio empleadoRepo;
	
    // Errores al momento de ejecucion : Sujeto a Revision 👇
	/*
	@Autowired 
	private IEmpleadoServicio empleadoServicio; 
	
	@GetMapping("/listar")
	private List<Empleado> listarEmpleados() {
		return empleadoServicio._getTodosEmpleados();
	}
	*/  
	
	@GetMapping("/listar")
	private List<Empleado> listarEmpleados() {
		return empleadoRepo.findAll();  
	}
		
	
	// -------------------------Prueba-----------------------
	@GetMapping("/imprimir")
	public void print() {
		//List<Empleado> lista = ( List<Empleado> ) empleadoServicio._getTodosEmpleados();  
		System.out.println("*******Imprime desde Spring boot empleados******");
	}

}
