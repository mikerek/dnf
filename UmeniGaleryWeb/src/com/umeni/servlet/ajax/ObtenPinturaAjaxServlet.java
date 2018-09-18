package com.umeni.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeni.controller.LoginController;

public class ObtenPinturaAjaxServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProducto = request.getParameter( "idProducto" );
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
