package com.umeni.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeni.controller.LoginController;

/**
 * Servlet implementation class ValidaUsuarioServlet
 */
@WebServlet("/ValidaUsuarioAjaxServlet")
public class ValidaUsuarioAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Este es un servlet dedicado a la validacion de login del usuario
	 * Se hizo una modificaci�n al proyecto cambiando en esta clase la variable "nombre" por "loginId"
	 * Como dato interesante: 
	 *  - Previa fecha de cambio 06/03/14
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @author Miguel Rodriguez
	 * @date 12/03/14
	 * @param reques, response
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginId = request.getParameter( "loginId" );
		System.out.println("Tenemos al usuario : " + loginId);
		PrintWriter out = response.getWriter();
		if ( LoginController.emailFormationEvaluation( loginId ) ) {
			
			if( LoginController.existingUser( loginId ) ) {
				
				out.print( "<font color='green'>El usuario existe en la base de datos!</font>" );
				
			}
			else {
				
				out.print( "<font color='red'>El NO usuario existe en la base de datos!</font>" );
			
			}
			
		}
		else {
			
			out.print( "<font color='red'>Lo que acabas de ingresar NO tiene formacion correcta; seguro que es un email?</font>" );
			
		}
	}

}
