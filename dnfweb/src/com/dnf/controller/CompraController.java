package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.CompraBean;
import com.dnf.db.dao.CompraDAO;
import com.google.gson.Gson;


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
