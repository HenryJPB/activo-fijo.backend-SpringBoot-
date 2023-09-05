package com.mundoinformatico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundoinformatico.interfaz.IServicioEmpleado;
import com.mundoinformatico.modelo.Empleado;
import com.mundoinformatico.repositorio.EmpleadoRepositorio;

@Service
public class ServicioEmpleado  implements IServicioEmpleado {

	@Autowired
	private EmpleadoRepositorio empleadoRepo;  

	@Override
	public List<Empleado> _getEmpleados() {
		// TODO Auto-generated method stub
		return empleadoRepo.findAll();
	}

}
