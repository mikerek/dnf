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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "../login.jsp";

		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		String nombreUsuario = request.getParameter("nombreUsuario");
		String emailUsuario = request.getParameter("emailUsuario");
		String passwordUsuario = request.getParameter("passwordUsuario");
		int idRol = Integer.parseInt(request.getParameter("idRol"));
		UsuarioBean userBean = new UsuarioBean();
		userBean.setId_Usuario(idUsuario);
		userBean.setEmail(emailUsuario);
		userBean.setPassword(passwordUsuario);
		userBean.setId_Rol(idRol);

		boolean cambioUsuario = false;
		cambioUsuario = UsuarioController.changeUser(userBean);

		System.out.println("Tenemos: " + cambioUsuario);

		if (cambioUsuario) {

			nextPage = "/administracion/operacionUsuarioCorrecta.jsp";

		} else {

			nextPage = "/administracion/operacionUsuarioIncorrecta";

		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int idUsuario = Integer.parseInt( request.getParameter( "nombreUsuario" ).trim() );
		UsuarioBean usuario = UsuarioController.getAllDataFromUserByIdUser( idUsuario );
		session.setAttribute( "usuario", usuario );
		String returnData = "<div class= \"container \"> "
				+ "<form action= \"../CambiaUsuarioServlet \" method= \"post \" onsubmit= \"javascript:return validaNuevoUsuario(); \"> "
				+ "<div class= \"row \"> 	"
				+ "<div class= \"col col-md-4 mx-auto \"> "
				+ "<label for= \"nombreUsuario \">Nombre de Usuario</label> "
				+ "<input type= \"text \" class= \"form-control \" name= \"nombreUsuario \" id= \"nombreUsuario \" value= \""+ usuario.getNombre()+ " \"> 	"
				+ "</div> "
				
				+ "<div class= \"col col-md-4 mx-auto \"> "
				+ "<label for= \"emailUsuario \">Email de Usuario</label> "
				+ "<input type= \"email \" class= \"form-control \" name= \"emailUsuario \" id= \"emailUsuario \" value= \""+ usuario.getEmail() + " \"> 	"
				+ "</div> "
				
				+ "<div class= \"col col-md-4 mx-auto \"> "
				+ "<label for= \"passwordUsuario \">Password de Usuario</label> "
				+ "<input type= \"password \" class= \"form-control \" name= \"passwordUsuario \" id= \"passwordUsuario \" value= \""+ usuario.getPassword() + " \"> 	"
				+ "</div> "

				+ "</div>  "
				+ "<div class= \"row \"> 	"
				+ "<div class= \"col col-md-4 mx-auto \"> "
				+ "<button type= \"submit \" class= \"btn btn-outline-info btn-block \">Modificar usuario</button> 	"
				+ "</div> "
				+ "</div> "
				+ "</form> "
				+ "</div>";
		response.setContentType( "text/html" ); // Set content type of the response so that jQuery knows what it can
												// expect.
		response.setCharacterEncoding( "UTF-8" ); // You want world domination, huh?
		response.getWriter().write( returnData );

	}

}
