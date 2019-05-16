package com.umeni.db.bean;

public class ArticuloTipoBean {
	
	private int id_articulo_tipo;
	private String descripcion;
	
	public ArticuloTipoBean() {
		
	}

	public int getId_articulo_tipo() {
		return id_articulo_tipo;
	}

	public void setId_articulo_tipo(int id_articulo_tipo) {
		this.id_articulo_tipo = id_articulo_tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ArticuloTipoBean [id_articulo_tipo=" + id_articulo_tipo + ", descripcion=" + descripcion + "]";
	}

}