package com.umeni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeni.controller.UsuarioController;

@WebServlet("/EliminarUsuarioServlet")
public class EliminarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "../login.jsp";
		
		int idUsuario = Integer.parseInt( request.getParameter( "idUsuario" ) );
		
		boolean usuarioEliminado = false;
		usuarioEliminado = UsuarioController.deleteUser( idUsuario );
		HttpSession session = request.getSession( );
		session.setAttribute("operacionUsuario", "Baja Usuario");
		session.setAttribute( "listaUsuarios" , UsuarioController.getAllUsers() );
		
		if( usuarioEliminado ) {
			
			nextPage = "/administracion/operacionUsuarioCorrecta.jsp";
		
		}
		else {
			
			nextPage = "/administracion/operacionUsuarioIncorrecta";
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);
	}

}
