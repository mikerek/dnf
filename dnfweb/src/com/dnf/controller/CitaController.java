package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.CitaBean;
import com.dnf.db.bean.ConsultaCitaBean;
import com.dnf.db.dao.CitaDAO;

public class CitaController {
	
	public static boolean agendarCita( CitaBean bean) {
		
		boolean insertionFlag = false;
		insertionFlag = CitaDAO.agendarCita( bean );
		return insertionFlag;
		
	}
	
	public static ArrayList< ConsultaCitaBean > obtenerCitasPorDia( String dia ) {
		
		return CitaDAO.obtenerCitasPorFecha( dia );
		
	}
	
	public static boolean espacioReservado( int idBarbero, String dia, String hora ) {
		
		return CitaDAO.espacioReservado( idBarbero, dia, hora );
		
	}
	
	public static ArrayList< ConsultaCitaBean > obtenerCitasDelMes( ) {
		
		return CitaDAO.obtenerCitasDelMes();
		
	}
	
	public static ConsultaCitaBean obtenerCitaPorClienteYFecha( int idCliente, String fecha ) {
		
		return CitaDAO.obtenerCitaPorClienteYFecha( idCliente, fecha );
		
	}
	
	public static ArrayList< ConsultaCitaBean > obtenerCitasPorBarbero( int idBarbero ) {
		
		return CitaDAO.obtenerCitasPorBarbero( idBarbero );
		
	}

}
