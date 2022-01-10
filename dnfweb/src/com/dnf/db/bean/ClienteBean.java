package com.dnf.db.bean;

public class ClienteBean {
	
	private int idCliente;
	private String nombre;
	private String rfc;
	private String telefono2;
	private String telefono;
	private String email;
	private int idCita;
	private String direccion;
	private int idTipoCliente;
	
	
	public String getTelefono2() {
		return telefono2;
	}


	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}


	public int getIdCita() {
		return idCita;
	}


	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}


	public ClienteBean() {
		super();
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getIdTipoCliente() {
		return idTipoCliente;
	}


	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	

}
