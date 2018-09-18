package com.umeni.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umeni.controller.PinturaController;

public class ObtenPinturaAjaxServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombrePintura = request.getParameter("nombrePintura");
		PrintWriter out = response.getWriter();

		if (PinturaController.obtenPintura( nombrePintura ) ) {

			out.print("<font color='green'>Producto <b>" + nombrePintura + "</b> encontrado!</font>");

		} else {

			out.print("<font color='red'>Producto NO encontrado</font>");

		}

	}
}
