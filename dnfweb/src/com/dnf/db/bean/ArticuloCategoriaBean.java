package com.dnf.db.bean;

public class ArticuloCategoriaBean {
	
	private int id_articulo_categoria;
	private String descripcion;
	
	public ArticuloCategoriaBean() {
		
	}
	
	@Override
	public String toString() {
		return "ArticuloCategoriaBean [id_articulo_categoria=" + id_articulo_categoria + ", descripcion=" + descripcion
				+ "]";
	}
	
	public ArticuloCategoriaBean(int id_articulo_categoria, String descripcion) {
		super();
		this.id_articulo_categoria = id_articulo_categoria;
		this.descripcion = descripcion;
	}
	public int getId_articulo_categoria() {
		return id_articulo_categoria;
	}
	public void setId_articulo_categoria(int id_articulo_categoria) {
		this.id_articulo_categoria = id_articulo_categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}