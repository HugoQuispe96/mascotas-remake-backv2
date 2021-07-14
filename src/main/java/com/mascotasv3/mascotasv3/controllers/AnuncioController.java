package com.mascotasv3.mascotasv3.controllers;

import java.util.ArrayList;
import java.util.Optional;
import javax.validation.Valid;

import com.mascotasv3.mascotasv3.models.AnuncioModel;
import com.mascotasv3.mascotasv3.models.ValidateAnuncioModel;
import com.mascotasv3.mascotasv3.services.AnuncioService;
import com.mascotasv3.mascotasv3.utils.GenerateAlphaNumericString;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
    @Autowired
    AnuncioService anuncioService;

    @GetMapping()
    public ArrayList<AnuncioModel> getAnuncios(){
        return anuncioService.getAnuncios();
    }

    @GetMapping(path = "/tipo_publicacion/{tipoPublicacion}")
    public ArrayList<AnuncioModel> getAnunciosByTipoPublicacion(@PathVariable("tipoPublicacion") Integer tipoPublicacion){
        return anuncioService.getAnunciosByTipoPublicacion(tipoPublicacion);
    }

    @GetMapping(path = "/tipo_mascota/{tipoMascota}")
    public ArrayList<AnuncioModel> getAnunciosByTipoMascota(@PathVariable("tipoMascota") Integer tipoMascota){
        return anuncioService.getAnunciosByTipoMascota(tipoMascota);
    }

    @GetMapping(path = "/tipo_mascota/{tipoMascota}/tipo_publicacion/{tipoPublicacion}")
    public ArrayList<AnuncioModel> getAnunciosByTipoMascotaAndTipoPublicacion(
        @PathVariable("tipoMascota") Integer tipoMascota,
        @PathVariable("tipoPublicacion") Integer tipoPublicacion){
        return anuncioService.getAnunciosByTipoMascotaAndTipoPublicacion(tipoMascota, tipoPublicacion);
    }
    
    @PostMapping()
    public ResponseEntity<Object> createAnuncio(@Valid @RequestBody ValidateAnuncioModel validateAnuncio, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
			return new ResponseEntity<Object>("Json fallo la validación", HttpStatus.BAD_REQUEST);
		}
        AnuncioModel anuncio = new AnuncioModel();
        anuncio.setTipoPublicacion(validateAnuncio.getTipoPublicacion());
        anuncio.setNombrePublicacion(validateAnuncio.getNombrePublicacion());
        anuncio.setColorMascota(validateAnuncio.getColorMascota());
        anuncio.setFechaPerdidaEncuentro(validateAnuncio.getFechaPerdidaEncuentro());
        anuncio.setTipoMascota(validateAnuncio.getTipoMascota());
        anuncio.setUrlFoto(validateAnuncio.getUrlFoto());
        anuncio.setDescripcion(validateAnuncio.getDescripcion());
        anuncio.setNombreContacto(validateAnuncio.getNombreContacto());
        anuncio.setTelefonoContacto(validateAnuncio.getTelefonoContacto());
        anuncio.setCorreoContacto(validateAnuncio.getCorreoContacto());
        anuncio.setCodigo(GenerateAlphaNumericString.getRandomString(6));

		return new ResponseEntity<Object>(this.anuncioService.saveAnuncio(anuncio), HttpStatus.OK);
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<Object> updateAnuncio(
        @PathVariable("id") Long id, 
        @Valid @RequestBody ValidateAnuncioModel validateAnuncio, 
        BindingResult bindingResult) 
    {
        if (bindingResult.hasErrors()) {
			return new ResponseEntity<Object>("Json fallo la validación", HttpStatus.BAD_REQUEST);
		}
        boolean noExisteAnuncio = !this.anuncioService.existsById(id);
        if(noExisteAnuncio){
            return new ResponseEntity<Object>("No se encuentra el ID", HttpStatus.BAD_REQUEST);
        }
        Optional<AnuncioModel> anuncioAnterior = this.anuncioService.getById(id);
        AnuncioModel anuncioNuevo = new AnuncioModel();
        anuncioNuevo.setId(id);
        anuncioNuevo.setTipoPublicacion(validateAnuncio.getTipoPublicacion());
        anuncioNuevo.setNombrePublicacion(validateAnuncio.getNombrePublicacion());
        anuncioNuevo.setColorMascota(validateAnuncio.getColorMascota());
        anuncioNuevo.setFechaPerdidaEncuentro(validateAnuncio.getFechaPerdidaEncuentro());
        anuncioNuevo.setTipoMascota(validateAnuncio.getTipoMascota());
        anuncioNuevo.setUrlFoto(validateAnuncio.getUrlFoto());
        anuncioNuevo.setDescripcion(validateAnuncio.getDescripcion());
        anuncioNuevo.setNombreContacto(validateAnuncio.getNombreContacto());
        anuncioNuevo.setTelefonoContacto(validateAnuncio.getTelefonoContacto());
        anuncioNuevo.setCorreoContacto(validateAnuncio.getCorreoContacto());
        anuncioNuevo.setCodigo(anuncioAnterior.get().getCodigo());
        
        return new ResponseEntity<Object>(this.anuncioService.saveAnuncio(anuncioNuevo), HttpStatus.OK);
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