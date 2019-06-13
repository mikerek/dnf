package com.umeni.controller;

import java.util.ArrayList;

import com.umeni.db.bean.ProductoBean;
import com.umeni.db.bean.ProductoMedidaBean;
import com.umeni.db.dao.ProductoDAO;
import com.umeni.db.dao.ProductoMedidaDAO;

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
