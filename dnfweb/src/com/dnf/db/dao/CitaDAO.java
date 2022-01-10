package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dnf.db.bean.CitaBean;
import com.dnf.db.bean.ConsultaCitaBean;
import com.dnf.db.connection.ConexBD;

public class CitaDAO {
	
	public static boolean agendarCita( CitaBean bean) {

		boolean insertionFlag = false;
		String query = "INSERT INTO cita (dia, hora, id_cliente, id_sucursal, id_barbero, id_servicio) values (?,?,?,?,?,?) ";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement(query);
			ps.setString(1, bean.getDia());
			ps.setString(2, bean.getHora());
			ps.setInt(3, bean.getIdCliente());
			ps.setInt(4, bean.getIdSucursal());
			ps.setInt(5, bean.getIdBarbero());
			ps.setInt(6, bean.getIdServicio());
			insertionFlag = (ps.executeUpdate() == 1) ? true : false;

			con.close();
			
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return insertionFlag;

	}
	
	public static ConsultaCitaBean obtenerCitaPorClienteYFecha( int idCliente, String dia ) {
		
		ConsultaCitaBean bean = new ConsultaCitaBean();
		String query = "SELECT c.id_cita, c.dia, c.hora, c.id_cliente, c.id_sucursal, c.id_barbero, c.id_servicio, \n"
				+ "	cl.nombre nombreCliente, b.nombre nombreBarbero, se.servicio, se.precio, tc.tipo tipoCliente, se.duracion\n"
				+ "FROM cita  AS c \n"
				+ "INNER JOIN cliente AS cl  \n"
				+ "	ON c.id_cliente  = cl.id_cliente \n"
				+ "INNER JOIN  barbero AS b	\n"
				+ "	ON c.id_barbero  = b.id_barbero\n"
				+ "INNER JOIN servicio AS se\n"
				+ "	ON c.id_servicio  = se.id_servicio \n"
				+ "INNER JOIN tipo_cliente AS tc\n"
				+ "	ON cl.id_tipo_cliente = tc.id_tipo_cliente\n "
				+ "WHERE c.id_cliente = ? AND c.dia = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement(query);
			ps.setInt(1, idCliente);
			ps.setString(2, dia);
			rs = ps.executeQuery();
			while (rs.next()) {

				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDia( rs.getString( "dia" ) );
				bean.setHora( rs.getString( "hora" ) );
				bean.setIdSucursal( rs.getInt( "id_sucursal" ) );
				bean.setIdBarbero( rs.getInt( "id_barbero" ) );
				bean.setIdServicio( rs.getInt( "id_servicio" ) );
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombreCliente( rs.getString( "nombreCliente" ) );
				bean.setNombreBarbero( rs.getString( "nombreBarbero" ) );
				bean.setTipoServicio( rs.getString( "servicio") );
				bean.setPrecio( rs.getString( "precio" ) );
				bean.setTipoCliente( rs.getString( "tipoCliente") );
				bean.setDuracionServicio( rs.getString("duracion" ));
								

			}
			con.close();
		
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return bean;
	}
	
	public static ArrayList< ConsultaCitaBean > obtenerCitasPorFecha( String dia ) {
		
		ArrayList< ConsultaCitaBean > lista = new ArrayList< ConsultaCitaBean >();
		String query = "SELECT c.id_cita, c.dia, c.hora, c.id_cliente, c.id_sucursal, c.id_barbero, c.id_servicio, \n"
				+ "	cl.nombre nombreCliente, b.nombre nombreBarbero, se.servicio, se.precio, tc.tipo tipoCliente, se.duracion\n"
				+ "FROM cita  AS c \n"
				+ "INNER JOIN cliente AS cl  \n"
				+ "	ON c.id_cliente  = cl.id_cliente \n"
				+ "INNER JOIN  barbero AS b	\n"
				+ "	ON c.id_barbero  = b.id_barbero\n"
				+ "INNER JOIN servicio AS se\n"
				+ "	ON c.id_servicio  = se.id_servicio \n"
				+ "INNER JOIN tipo_cliente AS tc\n"
				+ "	ON cl.id_tipo_cliente = tc.id_tipo_cliente\n "
				+ "WHERE c.dia = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement(query);
			ps.setString(1, dia);
			rs = ps.executeQuery();
			while (rs.next()) {

				ConsultaCitaBean bean = new ConsultaCitaBean();
				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDia( rs.getString( "dia" ) );
				bean.setHora( rs.getString( "hora" ) );
				bean.setIdSucursal( rs.getInt( "id_sucursal" ) );
				bean.setIdBarbero( rs.getInt( "id_barbero" ) );
				bean.setIdServicio( rs.getInt( "id_servicio" ) );
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombreCliente( rs.getString( "nombreCliente" ) );
				bean.setNombreBarbero( rs.getString( "nombreBarbero" ) );
				bean.setTipoServicio( rs.getString( "servicio") );
				bean.setPrecio( rs.getString( "precio" ) );
				bean.setTipoCliente( rs.getString( "tipoCliente") );
				bean.setDuracionServicio( rs.getString("duracion" ));
				
				lista.add( bean );

			}
			con.close();
		
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
	}
	
	public static ArrayList< ConsultaCitaBean > obtenerCitasPorBarbero( int idBarbero ) {
		
		ArrayList< ConsultaCitaBean > lista = new ArrayList< ConsultaCitaBean >();
		String query = "SELECT c.id_cita, c.dia, c.hora, c.id_cliente, c.id_sucursal, c.id_barbero, c.id_servicio, \n"
				+ "	cl.nombre nombreCliente, b.nombre nombreBarbero, se.servicio, se.precio, tc.tipo tipoCliente, se.duracion\n"
				+ "FROM cita  AS c \n"
				+ "INNER JOIN cliente AS cl  \n"
				+ "	ON c.id_cliente  = cl.id_cliente \n"
				+ "INNER JOIN  barbero AS b	\n"
				+ "	ON c.id_barbero  = b.id_barbero\n"
				+ "INNER JOIN servicio AS se\n"
				+ "	ON c.id_servicio  = se.id_servicio \n"
				+ "INNER JOIN tipo_cliente AS tc\n"
				+ "	ON cl.id_tipo_cliente = tc.id_tipo_cliente\n "
				+ "WHERE c.id_barbero = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setInt( 1, idBarbero );
			rs = ps.executeQuery();
			while ( rs.next() ) {

				ConsultaCitaBean bean = new ConsultaCitaBean();
				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDia( rs.getString( "dia" ) );
				bean.setHora( rs.getString( "hora" ) );
				bean.setIdSucursal( rs.getInt( "id_sucursal" ) );
				bean.setIdBarbero( rs.getInt( "id_barbero" ) );
				bean.setIdServicio( rs.getInt( "id_servicio" ) );
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombreCliente( rs.getString( "nombreCliente" ) );
				bean.setNombreBarbero( rs.getString( "nombreBarbero" ) );
				bean.setTipoServicio( rs.getString( "servicio") );
				bean.setPrecio( rs.getString( "precio" ) );
				bean.setTipoCliente( rs.getString( "tipoCliente") );
				bean.setDuracionServicio( rs.getString("duracion" ));
				
				lista.add( bean );		

			}
			con.close();
		
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
	}
	
	public static ArrayList< CitaBean > obtenerCitasPorServicio( int idServicio ) {
		
		ArrayList< CitaBean > lista = new ArrayList< CitaBean >();
		String query = "SELECT id_cita, dia, hora, id_cliente, id_sucursal, id_barbero FROM cita WHERE id_servicio = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setInt( 1, idServicio );
			rs = ps.executeQuery();
			while ( rs.next() ) {

				CitaBean bean = new CitaBean();
				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDia( rs.getString( "dia" ) );
				bean.setHora( rs.getString( "hora" ) );
				bean.setIdSucursal( rs.getInt( "id_sucursal" ) );
				bean.setIdBarbero( rs.getInt( "id_barbero" ) );
				bean.setIdServicio( rs.getInt( "id_servicio" ) );
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
			

			}
			con.close();
		
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return lista;
	}
	
	public static boolean espacioReservado( int idBarbero, String dia, String hora ) {
		
		boolean banderaReservado = false;
		String query = "SELECT id_cita FROM cita WHERE id_barbero = ? AND dia = ? AND hora = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setInt( 1, idBarbero );
			ps.setString( 2, dia );
			ps.setString( 3, hora);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				banderaReservado = true;
				
			}
			con.close();
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return banderaReservado;
	}
	
	public static ArrayList< ConsultaCitaBean > obtenerCitasDelMes(  ) {
	
		ArrayList< ConsultaCitaBean > lista = new ArrayList< ConsultaCitaBean >();
		// >>>>  STR_TO_DATE(dia,\"%Y-%m-%d\")
		String query = "SELECT c.id_cita, c.dia, c.hora, c.id_cliente, c.id_sucursal, c.id_barbero, c.id_servicio, \n"
				+ "	cl.nombre nombreCliente, b.nombre nombreBarbero, se.servicio, se.precio, tc.tipo tipoCliente, se.duracion\n"
				+ "FROM cita  AS c \n"
				+ "INNER JOIN cliente AS cl  \n"
				+ "	ON c.id_cliente  = cl.id_cliente \n"
				+ "INNER JOIN  barbero AS b	\n"
				+ "	ON c.id_barbero  = b.id_barbero\n"
				+ "INNER JOIN servicio AS se\n"
				+ "	ON c.id_servicio  = se.id_servicio \n"
				+ "INNER JOIN tipo_cliente AS tc\n"
				+ "	ON cl.id_tipo_cliente = tc.id_tipo_cliente\n"
				+ "WHERE  dia < LAST_DAY( CURDATE() ) ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
	
				ConsultaCitaBean bean = new ConsultaCitaBean();
				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDia( rs.getString( "dia" ) );
				bean.setHora( rs.getString( "hora" ) );
				bean.setIdSucursal( rs.getInt( "id_sucursal" ) );
				bean.setIdBarbero( rs.getInt( "id_barbero" ) );
				bean.setIdServicio( rs.getInt( "id_servicio" ) );
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombreCliente( rs.getString( "nombreCliente" ) );
				bean.setNombreBarbero( rs.getString( "nombreBarbero" ) );
				bean.setTipoServicio( rs.getString( "servicio") );
				bean.setPrecio( rs.getString( "precio" ) );
				bean.setTipoCliente( rs.getString( "tipoCliente") );
				bean.setDuracionServicio( rs.getString("duracion" ));
				
				lista.add( bean );
	
			}
			con.close();
		
		} catch (SQLException ex) {
	
			ex.printStackTrace();
	
		}
		return lista;
	}

}
