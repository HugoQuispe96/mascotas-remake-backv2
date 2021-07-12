package com.mascotasv3.mascotasv3.repositories;

import java.util.ArrayList;

import com.mascotasv3.mascotasv3.models.AnuncioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends CrudRepository<AnuncioModel, Long> {
  
}