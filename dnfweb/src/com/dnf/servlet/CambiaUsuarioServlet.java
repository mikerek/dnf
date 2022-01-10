package com.dnf.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dnf.controller.UsuarioController;
import com.dnf.db.bean.UsuarioBean;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "../login.jsp";
		HttpSession session = request.getSession();
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String nombreUsuario = request.getParameter("nombreUsuario");
		String emailUsuario = request.getParameter("emailUsuario");
		String passwordUsuario = request.getParameter("passwordUsuario");
		int idRol = Integer.parseInt(request.getParameter("idRol"));

		UsuarioBean userBean = new UsuarioBean();
		userBean.setId_Usuario(idUsuario);
		userBean.setNombre(nombreUsuario);
		userBean.setEmail(emailUsuario);
		userBean.setPassword(passwordUsuario);
		userBean.setId_Rol(idRol);

		boolean cambioUsuario = false;
		cambioUsuario = UsuarioController.changeUser(userBean);


		if (cambioUsuario) {

			nextPage = "/administracion/operacionUsuarioCorrecta.jsp";

		} else {

			nextPage = "/administracion/operacionUsuarioIncorrecta";

		}
		session.setAttribute("operacionUsuario", "update " + nombreUsuario);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int idUsuario = Integer.parseInt(request.getParameter("nombreUsuario").trim());
		UsuarioBean usuario = UsuarioController.getAllDataFromUserByIdUser(idUsuario);
		String json = UsuarioController.getAllDataFromUserJSONById(idUsuario);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		// response.getWriter().write( returnData );
		response.getWriter().print(json);
		response.getWriter().flush();

	}

}
