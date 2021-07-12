package com.mascotasv3.mascotasv3.models;

import javax.persistence.*;

@Entity
@Table(name = "anuncioMascotas")
public class AnuncioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Integer tipoPublicacion;
    private String nombrePublicacion;
    private String colorMascota;
    private String fechaPerdidaEncuentro;
    private Integer tipoMascota;
    private String urlFoto;
    private String descripcion;
    private String nombreContacto;
    private String telefonoContacto;
    private String correoContacto;
    private String codigo;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTipoPublicacion() {
		return this.tipoPublicacion;
	}

	public void setTipoPublicacion(Integer tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public String getNombrePublicacion() {
		return this.nombrePublicacion;
	}

	public void setNombrePublicacion(String nombrePublicacion) {
		this.nombrePublicacion = nombrePublicacion;
	}

	public String getColorMascota() {
		return this.colorMascota;
	}

	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}

	public String getFechaPerdidaEncuentro() {
		return this.fechaPerdidaEncuentro;
	}

	public void setFechaPerdidaEncuentro(String fechaPerdidaEncuentro) {
		this.fechaPerdidaEncuentro = fechaPerdidaEncuentro;
	}

	public Integer getTipoMascota() {
		return this.tipoMascota;
	}

	public void setTipoMascota(Integer tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public String getUrlFoto() {
		return this.urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getCorreoContacto() {
		return this.correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}    
}