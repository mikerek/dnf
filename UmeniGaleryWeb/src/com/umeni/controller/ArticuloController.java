package com.umeni.controller;

import java.util.ArrayList;

import com.umeni.db.bean.ArticuloBean;
import com.umeni.db.dao.ArticuloDAO;

public class ArticuloController {
	
public static ArrayList<ArticuloBean> obtenerTodosLasArticulos() {
		
		ArrayList<ArticuloBean> lista = ArticuloDAO.obtenerTodosLosArticulos();
		return lista;
		
	}

}
