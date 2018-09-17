package com.umeni.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RealizarCompraServlet")
public class RealizarCompraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String costoCompra = request.getParameter("compra");
		String comentarios = request.getParameter("comentarios");
		
		
	}
}
