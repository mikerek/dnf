package com.umeni.db.bean;

public class CompraBean {
	
	private int id_compra;
	private int id_articulo;
	private int cantidad; 
	private String precio_unitario;
	private String precio_total;
	private int id_usuario;
	private String detalles_compra;
	private String fecha_compra;
	
	public int getId_compra() {
		return id_compra;
	}
	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}
	public int getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(String precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public String getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(String precio_total) {
		this.precio_total = precio_total;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getDetalles_compra() {
		return detalles_compra;
	}
	public void setDetalles_compra(String detalles_compra) {
		this.detalles_compra = detalles_compra;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	
	@Override
	public String toString() {
		return "CompraBean [id_compra=" + id_compra + ", id_articulo=" + id_articulo + ", cantidad=" + cantidad
				+ ", precio_unitario=" + precio_unitario + ", precio_total=" + precio_total + ", id_usuario="
				+ id_usuario + ", detalles_compra=" + detalles_compra + ", fecha_compra=" + fecha_compra + "]";
	}
	
	
	

}
