package com.umeni.servlet;

import java.beans.beancontext.BeanContextProxy;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeni.controller.UsuarioController;
import com.umeni.db.bean.UsuarioBean;

/**
 * Servlet implementation class UsuarioDataServlet
 */
@WebServlet("/UsuarioDataServlet")
public class UsuarioDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombreUsuario = request.getParameter( "nombreUsuario" );
		UsuarioController control = new UsuarioController();
		UsuarioBean bean = control.getAllDataFromUserByName( nombreUsuario );
		HttpSession session = request.getSession( );
		session.setAttribute("operacionUsuario", "Baja Usuario");
		session.setAttribute( "beaUsuario" , bean );
		/*
		PrintWriter out = response.getWriter();
		out.print( "Obtuvimos la siguiente informacion: ID " + bean.getId_Usuario() + " Password: " + bean.getPassword() + " ID Rol: " + bean.getId_Rol());
		*/
		
	}


}
