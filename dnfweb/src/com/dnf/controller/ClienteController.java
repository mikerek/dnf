package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.ClienteBean;
import com.dnf.db.dao.ClienteDAO;

public class ClienteController {
	
public static ArrayList<ClienteBean> obtenerTodosLosCliente() {
		
		ArrayList<ClienteBean> lista = ClienteDAO.obtenerTodosLosClientes();
		return lista;
		
	}

}
