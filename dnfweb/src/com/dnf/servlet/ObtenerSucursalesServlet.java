package com.dnf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.controller.SucursalController;
import com.dnf.db.bean.SucursalBean;

/**
 * Servlet implementation class ObtenerSucursalesServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/ObtenerSucursalesServlet"})
public class ObtenerSucursalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList< SucursalBean > listaSucursales = new ArrayList<SucursalBean>();
		listaSucursales = SucursalController.obtenerTodasLasSucursales();
		request.setAttribute( "listaSucursales" , listaSucursales  );
	
	}

}
