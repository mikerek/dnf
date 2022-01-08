package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.ProductoBean;
import com.dnf.db.bean.ProductoMedidaBean;
import com.dnf.db.dao.ProductoDAO;
import com.dnf.db.dao.ProductoMedidaDAO;

public class PinturaController {
	
	public static boolean obtenPintura( String idProducto ) {
		
		boolean bandera = false;
		bandera = ProductoDAO.existeProducto( idProducto );
		return bandera;
		
	}
	
	public static ArrayList< ProductoBean > obtenerPinturas() {
		
		ArrayList< ProductoBean > listaPinturas = new ArrayList < ProductoBean >();
		listaPinturas = ProductoDAO.obtenerProductos();
		return listaPinturas;
		
	}
	
	public static ArrayList< ProductoMedidaBean > obtenerMedidasDeProductos() {
		
		ArrayList< ProductoMedidaBean > listaMedidas = new ArrayList<ProductoMedidaBean>();
		listaMedidas = ProductoMedidaDAO.obtenerTodasLasMedidas();
		return listaMedidas;
		
	}

}
