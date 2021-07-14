package com.mascotasv3.mascotasv3.repositories;

import java.util.ArrayList;

import com.mascotasv3.mascotasv3.models.AnuncioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends CrudRepository<AnuncioModel, Long> {
  public abstract ArrayList<AnuncioModel> findByTipoPublicacion(Integer tipoPublicacion);
  public abstract ArrayList<AnuncioModel> findByTipoMascota(Integer tipoMascota);
  public abstract ArrayList<AnuncioModel> findByTipoMascotaAndTipoPublicacion(Integer tipoMascota, Integer tipoPublicacion);
}