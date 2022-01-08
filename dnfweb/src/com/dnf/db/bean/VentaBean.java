package com.dnf.db.bean;

public class VentaBean {

	private int id_venta;
	private int id_producto;
	private int id_usuario;
	private float venta;
	private String fecha;
	private String hora;
	private String comentarios;
	
	public VentaBean() {
		
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public float getVenta() {
		return venta;
	}

	public void setVenta(float venta) {
		this.venta = venta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public VentaBean(int id_venta, int id_producto, int id_usuario, float venta, String fecha, String hora,
			String comentarios) {
		super();
		this.id_venta = id_venta;
		this.id_producto = id_producto;
		this.id_usuario = id_usuario;
		this.venta = venta;
		this.fecha = fecha;
		this.hora = hora;
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "VentaBean [id_venta=" + id_venta + ", id_producto=" + id_producto + ", id_usuario=" + id_usuario
				+ ", venta=" + venta + ", fecha=" + fecha + ", hora=" + hora + ", comentarios=" + comentarios + "]";
	}
	
	
	
}
