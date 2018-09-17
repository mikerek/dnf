package com.umeni.db.bean;

public class UsuarioBean {
	
	private int id_usuario;
	private String nombre;
	private String password;
	private int id_rol;
	private String email;
	
	public int getId_Usuario() {
		return id_usuario;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId_Usuario( int id_usuario ) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_Rol() {
		return id_rol;
	}

	public void setId_Rol(int id_rol) {
		this.id_rol = id_rol;
	}
	
	

}
