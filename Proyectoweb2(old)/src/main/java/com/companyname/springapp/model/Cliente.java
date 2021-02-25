package com.companyname.springapp.model;

import javax.validation.constraints.NotNull;

public class Cliente {
	
	private Integer id;
	@NotNull
	private Integer codigo;
	private String provincia;
	private String nombre;
	private String localidad;
	private String delegacion;
	
	public Cliente() {
	}
	
	public Cliente(Integer id, Integer codigo, String nombre, String delegacion, String provincia , String localidad) {
		this.id= id;
		this.codigo= codigo;
		this.nombre = nombre;
		this.delegacion =delegacion;
		this.provincia =provincia;
		this.localidad =localidad;
	}
 
	public Integer getId() {
		return id;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getDelegacion() {
		return delegacion;
	}
 
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public String getProvincia() {
		return provincia;
	}
 
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getLocalidad() {
		return localidad;
	}
 
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return this.id+", "+ this.codigo+", "+this.nombre+", "+this.delegacion+", "+this.provincia+", "+this.localidad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj instanceof Cliente) {
			Cliente c = (Cliente) obj;
			if (c.getId() == null)
				return false;

			return this.getId().equals(c.getId());
		} else {
			return false;
		}
	}
}
