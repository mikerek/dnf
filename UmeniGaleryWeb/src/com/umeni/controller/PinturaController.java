package com.umeni.controller;

import java.util.ArrayList;

import com.umeni.db.bean.ProductoBean;
import com.umeni.db.dao.PinturaDAO;

public class PinturaController {
	
	public static boolean obtenPintura( String idProducto ) {
		
		boolean bandera = false;
		bandera = PinturaDAO.existeProducto( idProducto );
		return bandera;
		
	}
	
	public static ArrayList< ProductoBean > obtenerPinturas() {
		
		ArrayList< ProductoBean > listaPinturas = new ArrayList < ProductoBean >();
		listaPinturas = PinturaDAO.obtenerPinturas();
		return listaPinturas;
		
	}

}
