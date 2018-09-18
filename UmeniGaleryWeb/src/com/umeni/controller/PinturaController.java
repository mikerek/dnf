package com.umeni.controller;

import java.util.ArrayList;

import com.umeni.db.bean.PinturaBean;
import com.umeni.db.dao.PinturaDAO;

public class PinturaController {
	
	public static boolean obtenPintura( String idProducto ) {
		
		boolean bandera = false;
		bandera = PinturaDAO.existeProducto( idProducto );
		return bandera;
		
	}
	
	public static ArrayList< PinturaBean > obtenerPinturas() {
		
		ArrayList< PinturaBean > listaPinturas = new ArrayList < PinturaBean >();
		listaPinturas = PinturaDAO.obtenerPinturas();
		return listaPinturas;
		
	}

}
