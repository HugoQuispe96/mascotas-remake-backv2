package com.mascotasv3.mascotasv3.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.mascotasv3.mascotasv3.models.AnuncioModel;
import com.mascotasv3.mascotasv3.services.AnuncioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
    @Autowired
    AnuncioService anuncioService;

    @GetMapping()
    public ArrayList<AnuncioModel> getAnuncios(){
        return anuncioService.getAnuncios();
    }

    @PostMapping()
    public AnuncioModel createAnuncio(@RequestBody AnuncioModel anuncio){
        return this.anuncioService.createAnuncio(anuncio);
    }

    @GetMapping( path = "/{id}")
    public Optional<AnuncioModel> getById(@PathVariable("id") Long id) {
        return this.anuncioService.getById(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean wasCreated = this.anuncioService.deleteAnuncio(id);
        if (wasCreated){
            return "Se eliminó el anuncio correctamente";
        }else{
            return "No pudo eliminar el anuncio con id: " + id;
        }
    }

}