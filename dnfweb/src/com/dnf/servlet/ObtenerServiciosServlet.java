package com.dnf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.controller.ServicioController;
import com.dnf.db.bean.ServicioBean;

/**
 * Servlet implementation class ObtenerServiciosServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/ObtenerServiciosServlet" })
public class ObtenerServiciosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList< ServicioBean > listaServicios = ServicioController.obtenerListaServicios();
		request.setAttribute( "listaServicios" , listaServicios );
		
	}

}
