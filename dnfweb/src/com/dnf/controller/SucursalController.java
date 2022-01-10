package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.SucursalBean;
import com.dnf.db.dao.SucursalDAO;

public class SucursalController {
	
public static ArrayList<SucursalBean> obtenerTodasLasSucursales() {
		
		ArrayList<SucursalBean> lista = SucursalDAO.obtenerTodasLasSucursales();
		return lista;
		
	}

}
