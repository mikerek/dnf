package com.dnf.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.controller.CompraController;

@WebServlet("/ReporteCompletoServlet")
public class ReporteCompletoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException {
		
		
		String comprasJSON = CompraController.obtenerTodasLasComprasJSON();
		System.out.println( ">>>>>>>>>>>>>>>>" + comprasJSON );
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); 
		// response.getWriter().write( returnData );
		response.getWriter().print( comprasJSON );
		response.getWriter().flush();
		
		
	}

}
