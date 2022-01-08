package com.dnf.db.bean;

public class ArticuloHistoriaCompraBean {
	
	private int id_articulo_historia_venta;
	private int id_articulo;
	private int precio_base;
	private String especificacion;
	
	public ArticuloHistoriaCompraBean() {
		
	}

	public int getId_articulo_historia_venta() {
		return id_articulo_historia_venta;
	}

	public void setId_articulo_historia_venta(int id_articulo_historia_venta) {
		this.id_articulo_historia_venta = id_articulo_historia_venta;
	}

	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public int getPrecio_base() {
		return precio_base;
	}

	public void setPrecio_base(int precio_base) {
		this.precio_base = precio_base;
	}

	public String getEspecificacion() {
		return especificacion;
	}

	public void setEspecificacion(String especificacion) {
		this.especificacion = especificacion;
	}
	
	
}