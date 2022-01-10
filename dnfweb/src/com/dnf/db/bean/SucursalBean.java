package com.dnf.db.bean;

public class SucursalBean {
	
	private int idSucursal;
	private String direccion;
	private String telefono;
	private String horario;
	private int id_cita;
	
	
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getIdCita() {
		return id_cita;
	}
	public void setIdCita(int id_cita) {
		this.id_cita = id_cita;
	}

}
