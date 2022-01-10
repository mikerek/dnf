package com.dnf.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.db.bean.CitaBean;
import com.dnf.db.bean.ConsultaCitaBean;
import com.dnf.controller.CitaController;

/**
 * Servlet implementation class ObtenerCitasDelMesServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/ObtenerCitasDelMesServlet"})
public class ObtenerCitasDelMesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		
		ArrayList < ConsultaCitaBean > listaDeCitasDelMes = CitaController.obtenerCitasDelMes();
		request.setAttribute( "listaDeCitasDelMes" , listaDeCitasDelMes );
		
	}

}
