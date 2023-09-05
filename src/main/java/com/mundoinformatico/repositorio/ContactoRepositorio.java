package com.mundoinformatico.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.mundoinformatico.modelo.Contacto;

public interface ContactoRepositorio extends CrudRepository<Contacto, Integer> {

}
