package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.ArticuloBean;
import com.dnf.db.dao.ArticuloDAO;

public class ArticuloController {
	
public static ArrayList<ArticuloBean> obtenerTodosLasArticulos() {
		
		ArrayList<ArticuloBean> lista = ArticuloDAO.obtenerTodosLosArticulos();
		return lista;
		
	}

}
