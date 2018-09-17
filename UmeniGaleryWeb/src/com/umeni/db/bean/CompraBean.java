package com.umeni.db.bean;

public class CompraBean {
	
	private int id_compra;
	private int id_usuario;
	private float compra;
	private String fecha;
	private String hora;
	private String comentarios;
	
	public CompraBean() {
		
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public float getCompra() {
		return compra;
	}

	public void setCompra(float compra) {
		this.compra = compra;
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

	public CompraBean(int id_compra, int id_usuario, float compra, String fecha, String hora, String comentarios) {
		super();
		this.id_compra = id_compra;
		this.id_usuario = id_usuario;
		this.compra = compra;
		this.fecha = fecha;
		this.hora = hora;
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "CompraBean [id_compra=" + id_compra + ", id_usuario=" + id_usuario + ", compra=" + compra + ", fecha="
				+ fecha + ", hora=" + hora + ", comentarios=" + comentarios + "]";
	}
	
	

}
