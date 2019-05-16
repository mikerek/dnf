package com.umeni.db.bean;

public class ArticuloHistoriaVentaBean {
	
	private int id_articulo_historia_compra;
	private int id_articulo;
	private int costo_base;
	private String especificacion;
	
	public ArticuloHistoriaVentaBean() {
		
	}

	public int getId_articulo_historia_compra() {
		return id_articulo_historia_compra;
	}

	public void setId_articulo_historia_compra(int id_articulo_historia_compra) {
		this.id_articulo_historia_compra = id_articulo_historia_compra;
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public int getCosto_base() {
		return costo_base;
	}

	public void setCosto_base(int costo_base) {
		this.costo_base = costo_base;
	}

	public String getEspecificacion() {
		return especificacion;
	}

	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}
	
	
	
}