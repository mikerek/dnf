package com.dnf.db.bean;

public class RolBean {

	int id_rol;
	String nombre;
	
	public RolBean() {
		
	}
	
	public RolBean(int id_rol, String nombre) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "RolBean [id_rol=" + id_rol + ", nombre=" + nombre + "]";
	}
	
	public int getId_rol() {
		return id_rol;
	}
	
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
