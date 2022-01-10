package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.BarberoBean;
import com.dnf.db.dao.BarberoDAO;

public class BarberoController {
	
	public static ArrayList< BarberoBean > obtenerBarberos(){
		
		ArrayList< BarberoBean > lista = new ArrayList<BarberoBean>();
		lista = BarberoDAO.obtenerTodosLosBarberos();
		return lista;
		
	}

}
