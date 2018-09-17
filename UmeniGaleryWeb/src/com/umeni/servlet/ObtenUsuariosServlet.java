package com.umeni.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umeni.controller.NewUserController;
import com.umeni.controller.UsuarioController;
import com.umeni.db.bean.UsuarioBean;

@WebServlet("/ObtenUsuariosServlet")
public class ObtenUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession( );
		ArrayList< UsuarioBean > listaUsuarios = UsuarioController.getAllUsers();
		session.setAttribute( "listaUsuarios" , listaUsuarios );
		
	}
}
