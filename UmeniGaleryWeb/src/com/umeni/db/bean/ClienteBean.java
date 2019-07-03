package com.umeni.db.bean;

public class ClienteBean {
	
	private int idCliente;
	private String nombre;
	private String rfc;
	private String persona;
	private String telefono;
	private String email;
	private String cargo;
	private String direccion;
	private int idTipoCliente;
	private String condiciones;
	
	
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


	public String getPersona() {
		return persona;
	}


	public void setPersona(String persona) {
		this.persona = persona;
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


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
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


	public String getCondiciones() {
		return condiciones;
	}


	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}
	
	
	

}
