package com.dnf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.controller.CitaController;
import com.dnf.db.bean.ConsultaCitaBean;

/**
 * Servlet implementation class ObtenerCitasServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ObtenerCitasServlet" })
public class ObtenerCitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList < ConsultaCitaBean > listaDeCitas = new ArrayList<ConsultaCitaBean>();
		int tipoBusqueda = Integer.parseInt( request.getParameter( "tipoBusqueda" ) );
		
		
		String nextPage = "/citas/resBusquedaCitas.jsp";
		
		switch( tipoBusqueda ) {
			case 1:
					listaDeCitas = CitaController.obtenerCitasPorDia( request.getParameter( "fechaFiltro" ) );
					break;
			
			case 2:
					listaDeCitas = CitaController.obtenerCitasPorBarbero( Integer.parseInt(request.getParameter( "idBarberoCita" ) ) );
					break;
					
			case 3:
					String fecha = request.getParameter( "fechaFiltro" );
					int clienteId= Integer.parseInt( request.getParameter( "idClienteCita" ) );
					listaDeCitas.add( CitaController.obtenerCitaPorClienteYFecha( clienteId, fecha ) );
					break;
		}
		request.setAttribute( "listaDeCitas" , listaDeCitas );
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward(request, response);
		
	}

}
