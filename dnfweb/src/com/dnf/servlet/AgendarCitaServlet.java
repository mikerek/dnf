package com.dnf.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dnf.controller.CitaController;
import com.dnf.db.bean.CitaBean;

/**
 * Servlet implementation class AgendarCitaServlet
 */
@WebServlet("/AgendarCitaServlet")
public class AgendarCitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendarCitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		CitaBean bean = new CitaBean();
		bean.setIdCliente( Integer.parseInt(request.getParameter( "idClienteCita" ) ) );
		bean.setDia( request.getParameter( "fechaCita" ) );
		bean.setHora( request.getParameter( "horaCita" ) );
		bean.setIdBarbero( Integer.parseInt( request.getParameter( "idBarberoCita" ) ) );
		bean.setIdServicio( Integer.parseInt( request.getParameter( "idServicioCita" ) ));
		//Solo se tiene una sucursal de momento
		bean.setIdSucursal( 1 );
		//*********
		
		
		boolean banderaOcupado = true;
		banderaOcupado = CitaController.espacioReservado( bean.getIdBarbero(), bean.getDia(), bean.getHora() );
		String nextPage = "";
		if( banderaOcupado  ) {
			
			nextPage = "/citas/errorEnCita.jsp";
			
		}
		else {
			
			if( CitaController.agendarCita( bean ) )
				nextPage = "/citas/citaRegistrada.jsp";
			else 
				nextPage = "/citas/errorEnCita.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward(request, response);
		
	}

}
