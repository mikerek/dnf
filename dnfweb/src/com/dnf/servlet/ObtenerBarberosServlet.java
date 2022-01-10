package com.dnf.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dnf.controller.BarberoController;
import com.dnf.db.bean.BarberoBean;

/**
 * Servlet implementation class ObtenerBarberosServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/ObtenerBarberosServlet"})
public class ObtenerBarberosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList< BarberoBean > listaBarberos = new ArrayList<BarberoBean>();
		listaBarberos = BarberoController.obtenerBarberos();
		request.setAttribute( "listaBarberos" , listaBarberos );
		
	}

}
