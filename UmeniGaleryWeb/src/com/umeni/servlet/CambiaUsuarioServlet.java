package com.umeni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeni.controller.UsuarioController;
import com.umeni.db.bean.UsuarioBean;

/**
 * Servlet implementation class CambiaUsuarioServlet
 */
@WebServlet("/CambiaUsuarioServlet")
public class CambiaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaUsuarioServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "../login.jsp";
		
		int idUsuario = Integer.parseInt( request.getParameter( "idUsuario" ) );
		String nombreUsuario = request.getParameter( "nombreUsuario" );
		String emailUsuario = request.getParameter( "emailUsuario" );
		String passwordUsuario = request.getParameter( "passwordUsuario" );
		int idRol = Integer.parseInt( request.getParameter( "idRol" ) );
		UsuarioBean userBean = new UsuarioBean();
		userBean.setId_Usuario( idUsuario );
		userBean.setEmail( emailUsuario );
		userBean.setPassword( passwordUsuario );
		userBean.setId_Rol( idRol );
		
		boolean cambioUsuario = false;
		cambioUsuario = UsuarioController.changeUser( userBean );
		
		System.out.println("Tenemos: " + cambioUsuario);
		
		if( cambioUsuario ) {
			
			nextPage = "/administracion/operacionUsuarioCorrecta.jsp";
		
		}
		else {
			
			nextPage = "/administracion/operacionUsuarioIncorrecta";
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);
		
	}

}
