package com.umeni.db.bean;

public class PermisoBean {
	
	private int id_permiso;
	private String descripcion;
	private String Url;
	
	public PermisoBean() {
		
	}
	
	public int getId_permiso() {
		return id_permiso;
	}
	public void setId_permiso(int id_permiso) {
		this.id_permiso = id_permiso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	

}
