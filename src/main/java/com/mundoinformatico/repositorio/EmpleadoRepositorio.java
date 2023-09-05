package com.mundoinformatico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mundoinformatico.modelo.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

}
