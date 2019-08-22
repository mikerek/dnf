package com.umeni.controller;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.umeni.db.bean.CompraBean;
import com.umeni.db.dao.CompraDAO;


public class CompraController {
	
	/*
	public static boolean registrarCompra( CompraBean compraBean ) {
		
		boolean bandera = CompraDAO.registrarCompra( compraBean );
		return bandera;
		
	}
	*/
	
	public static ArrayList<CompraBean> obtenerTodasLasCompras() {
		
		ArrayList<CompraBean> lista = CompraDAO.obtenerTodasLasCompras();
		return lista;
		
	}
	
	public static String obtenerTodasLasComprasJSON( ) {

		Gson gsonObject = new Gson();
		ArrayList< CompraBean > lista = obtenerTodasLasCompras();
		return gsonObject.toJson( lista );

	}
	
}
