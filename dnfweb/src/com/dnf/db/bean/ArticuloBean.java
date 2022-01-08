package com.dnf.db.bean;

public class ArticuloBean {

	private int id_articulo;
	private int id_articulo_tipo;
	private int id_articulo_categoria;
	private String descripcion;
	
	public ArticuloBean() {
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public int getId_articulo_tipo() {
		return id_articulo_tipo;
	}

	public void setId_articulo_tipo(int id_articulo_tipo) {
		this.id_articulo_tipo = id_articulo_tipo;
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

	@Override
	public String toString() {
		return "ArticuloBean [id_articulo=" + id_articulo + ", id_articulo_tipo=" + id_articulo_tipo
				+ ", id_articulo_categoria=" + id_articulo_categoria + ", descripcion=" + descripcion + "]";
	}
	
}
