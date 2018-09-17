package com.umeni.db.bean;

public class PinturaBean {
	
	private int id_producto;
	private String nombre;
	private String descripcion;
	private float precio;
	private int id_categoria;
	private String detalles;
	private String imagen;
	private String imagen2;
	private String imagen3;
	
	public PinturaBean() {
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public String getImagen3() {
		return imagen3;
	}

	public void setImagen3(String imagen3) {
		this.imagen3 = imagen3;
	}

	public PinturaBean(int id_producto, String nombre, String descripcion, float precio, int id_categoria,
			String detalles, String imagen, String imagen2, String imagen3) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.id_categoria = id_categoria;
		this.detalles = detalles;
		this.imagen = imagen;
		this.imagen2 = imagen2;
		this.imagen3 = imagen3;
	}

	@Override
	public String toString() {
		return "PinturaBean [id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", id_categoria=" + id_categoria + ", detalles=" + detalles + ", imagen="
				+ imagen + ", imagen2=" + imagen2 + ", imagen3=" + imagen3 + "]";
	}
	
	

}
