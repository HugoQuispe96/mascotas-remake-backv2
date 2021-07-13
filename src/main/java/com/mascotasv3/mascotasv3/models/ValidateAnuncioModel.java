package com.mascotasv3.mascotasv3.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Email;


public class ValidateAnuncioModel {
  @NotNull(message="Campo tipoPublicacion no puede ser null")
	@Min(value=0, message = "Campo tipoPublicacion debe ser mayor o igual a 0")
  @Max(value=1, message = "Campo tipoPublicacion debe ser menor o igual a 1")
  private Integer tipoPublicacion;
	@NotNull(message="Campo nombrePublicacion no puede ser null")
  @Size(min=2,max=20, message="Campo nombrePublicacion debe tener entre 2 y 20 caracteres")
  private String nombrePublicacion;
  @NotNull(message="Campo colorMascota no puede ser null")
  @Size(min=2,max=20, message="Campo colorMascota debe tener entre 2 y 20 caracteres")
  private String colorMascota;
  @NotNull(message="Campo fechaPerdidaEncuentro no puede ser null")
  @Size(min=2,max=20, message="Campo fechaPerdidaEncuentro debe tener entre 2 y 20 caracteres")
  private String fechaPerdidaEncuentro;
  @NotNull(message="Campo tipoMascota no puede ser null")
	@Min(value=0, message = "Campo tipoMascota debe ser mayor o igual a 0")
  @Max(value=2, message = "Campo tipoMascota debe ser menor o igual a 2")
  private Integer tipoMascota;
  @NotNull(message="Campo urlFoto no puede ser null")
  @Size(min=2,max=250, message="Campo urlFoto debe tener entre 2 y 250 caracteres")
  private String urlFoto;
  @NotNull(message="Campo descripcion no puede ser null")
  @Size(min=2,max=250, message="Campo descripcion debe tener entre 2 y 250 caracteres")
  private String descripcion;
  @NotNull(message="Campo nombreContacto no puede ser null")
  @Size(min=2,max=45, message="Campo nombreContacto debe tener entre 2 y 45 caracteres")
  private String nombreContacto;
  @NotNull(message="Campo telefonoContacto no puede ser null")
  @Size(min=2,max=12, message="Campo telefonoContacto debe tener entre 2 y 12 caracteres")
  private String telefonoContacto;
  @NotNull(message="Campo correoContacto no puede ser null")
  @Email(message="Campo correoContacto debe tener formato de correo")
  private String correoContacto;

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
}
