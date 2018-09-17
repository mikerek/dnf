package com.umeni.controller;

import com.umeni.db.bean.CompraBean;
import com.umeni.db.dao.CompraDAO;

public class CompraController {

	public static boolean registrarCompra( CompraBean compraBean ) {
		
		boolean bandera = CompraDAO.registrarCompra( compraBean );
		return bandera;
		
	}
	
}
