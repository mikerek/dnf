package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.ServicioBean;
import com.dnf.db.dao.ServicioDAO;

public class ServicioController {
	
	public static ArrayList< ServicioBean > obtenerListaServicios() {
		
		return ServicioDAO.obtenerTodosLosServicios();
		
	}

}
