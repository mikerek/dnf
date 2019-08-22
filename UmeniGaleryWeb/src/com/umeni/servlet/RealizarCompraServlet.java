package com.umeni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeni.controller.CompraController;
import com.umeni.db.bean.CompraBean;

@WebServlet("/RealizarCompraServlet")
public class RealizarCompraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String costoCompra = request.getParameter("compra");
		String comentarios = request.getParameter("comentarios");
		String idUsuario = request.getParameter("id_usuario");
		String fecha = request.getParameter("fecha");
		
		CompraBean compraBean = new CompraBean();
		//compraBean.setCompra( Float.parseFloat( costoCompra ) );
		//compraBean.setComentarios( comentarios );
		compraBean.setId_usuario( Integer.parseInt( idUsuario ) );
		//compraBean.setFecha( fecha );
		
		//boolean compraRealizada = CompraController.registrarCompra( compraBean );
		String nextPage = "";
		/*
		if( compraRealizada ) {
			
			nextPage = "/compras/compraRegistrada.jsp";
			
		}
		else {
			nextPage = "/compras/errorEnCompra.jsp";
		}
		*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);
		
		
	}
}
