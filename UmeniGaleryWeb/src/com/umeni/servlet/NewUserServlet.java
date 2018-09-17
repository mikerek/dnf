package com.umeni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeni.controller.NewUserController;
import com.umeni.controller.UsuarioController;
import com.umeni.db.bean.UsuarioBean;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "../login.jsp";
		
		String nombreUsuario = request.getParameter( "nombreUsuario" );
		String emailUsuario = request.getParameter( "emailUsuario" );
		String passwordUsuario = request.getParameter( "passwordUsuario" );
		String rolIdUsario = request.getParameter( "rolIdUsuario" );
		HttpSession session = request.getSession( );
		session.setAttribute("operacionUsuario", "Alta Usuario");
		session.setAttribute( "listaUsuarios" , UsuarioController.getAllUsers() );
		
		UsuarioBean bean = new UsuarioBean();
		bean.setNombre( nombreUsuario );
		bean.setPassword( passwordUsuario );
		bean.setEmail( emailUsuario );
		bean.setId_Rol( Integer.parseInt( rolIdUsario ) );
		
		boolean usuarioCreado = NewUserController.createNewUser( bean );
		
		System.out.println( "Creamos el usuario: " + usuarioCreado );
		
		if( usuarioCreado ) {
			
			nextPage = "/administracion/operacionUsuarioCorrecta.jsp";
		
		}
		else {
			
			nextPage = "/administracion/operacionUsuarioIncorrecta";
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);
		
	}

}
