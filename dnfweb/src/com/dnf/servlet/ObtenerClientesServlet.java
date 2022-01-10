package com.dnf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.controller.ClienteController;
import com.dnf.db.bean.ClienteBean;

/**
 * Servlet implementation class ObtenerClientesServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ObtenerClientesServlet" })
public class ObtenerClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList< ClienteBean > listaClientes = new ArrayList< ClienteBean >();
		listaClientes = ClienteController.obtenerTodosLosCliente();
		request.setAttribute( "listaClientes" , listaClientes );
		
	}

}
