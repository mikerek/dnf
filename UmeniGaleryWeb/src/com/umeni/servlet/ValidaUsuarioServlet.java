package com.umeni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeni.controller.ArticuloController;
import com.umeni.controller.LoginController;
import com.umeni.controller.PinturaController;
import com.umeni.controller.RolController;
import com.umeni.controller.UsuarioController;


@WebServlet("/ValidaUsuarioServlet")
public class ValidaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter( "loginId" );
		String passwd = request.getParameter( "passwordUsuario" );
		HttpSession session = request.getSession( );
		String nextPage = "";
		if ( LoginController.emailFormationEvaluation( loginId ) ) {
			
			if( LoginController.existingUser( loginId ) ) {
				
				if( LoginController.correctPassword( loginId , passwd ) ) {
					
					session.setAttribute( "beanUsuario" , LoginController.getAllDataFromUser( loginId ) );
					session.setAttribute( "listaMedidaPinturas", PinturaController.obtenerMedidasDeProductos() );
					session.setAttribute( "listBeanRol", RolController.getAllRoles() );
					session.setAttribute( "menu" , LoginController.menuGenerator( loginId ) );
					session.setAttribute( "listaUsuarios" , UsuarioController.getAllUsers() );
					session.setAttribute( "listaArticulos", ArticuloController.obtenerTodosLasArticulos() );
					nextPage = "/insideSystem.jsp";
					
				}
				else {
					
					nextPage = "/incorrectPassword.jsp";
					
				}
				
			}
			else {
				
				nextPage = "/inexistentUser.jsp";
			}
		}
		else {
			
			nextPage = "/inexistentUser.jsp";
			
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oper = request.getParameter( "oper" );
		String nextPage;
		if( !oper.equals(null) ) {
			HttpSession session = request.getSession( ); 
			session.setAttribute( "listaUsuarios" , UsuarioController.getAllUsers() );
			nextPage = "/insideSystem.jsp";
		}
		else {
			nextPage="/logout.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);
		
	}

}
