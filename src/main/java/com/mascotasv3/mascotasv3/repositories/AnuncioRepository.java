package com.mascotas.mascotas.repositories;

import java.util.ArrayList;

import com.mascotas.mascotas.models.AnuncioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends CrudRepository<AnuncioModel, Long> {
  
}