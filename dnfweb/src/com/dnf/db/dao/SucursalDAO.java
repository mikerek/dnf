package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dnf.db.bean.SucursalBean;
import com.dnf.db.connection.ConexBD;

public class SucursalDAO {
	
	public static ArrayList< SucursalBean > obtenerTodasLasSucursales() {
		
		ArrayList< SucursalBean > lista = new ArrayList<SucursalBean>();
		String query = "SELECT id_sucursal, direccion, telefono, horario, id_cita FROM sucursal";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {

				SucursalBean bean = new SucursalBean();
				bean.setIdSucursal( rs.getInt( "id_sucursal" ) );
				bean.setDireccion( rs.getString( "direccion" ));
				bean.setTelefono( rs.getString( "telefono" ) );
				bean.setHorario( rs.getString( "horario" ));
				bean.setIdCita( rs.getInt("id_cita") );

				lista.add(bean);

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return lista;
		
	}
	
	/*
	 *  Ya que solo tenemos una sucursal de momento, nos quedamos con estos metodos pendientes de implementar
	 */
	/*
	public static ClienteBean obtenerCliente( int idCliente ) {
		
		ClienteBean bean = new ClienteBean();
		String query = "SELECT id_cliente, nombre, rfc, telefono2, telefono, email, id_cita, direccion, id_tipo_cliente FROM cliente WHERE id_cliente = ?";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {

			ps = con.prepareStatement( query );
			rs = ps.executeQuery();
			while ( rs.next() ) {

				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombre( rs.getString( "nombre" ) );
				bean.setRfc( rs.getString( "rfc" ) );
				bean.setTelefono2( rs.getString( "telefono2" ) );
				bean.setTelefono( rs.getString( "telefono" ) );
				bean.setEmail( rs.getString( "email" ) );
				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDireccion( rs.getString( "direccion" ) );
				bean.setIdTipoCliente( rs.getInt("id_tipo_cliente") );

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return bean;
		
	}
	
	public static ArrayList< ClienteBean > obtenerTodosLosClientesByTipo( int idTipoCliente ) {
		
		ArrayList< ClienteBean > lista = new ArrayList<ClienteBean>();
		String query = "SELECT id_cliente, nombre, rfc, telefono2, telefono, email, id_cita, direccion, id_tipo_cliente FROM cliente WHERE id_tipo_cliente = ?";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {
			
			ps = con.prepareStatement( query );
			ps.setInt( 1, idTipoCliente );
			rs = ps.executeQuery();
			while ( rs.next() ) {

				ClienteBean bean = new ClienteBean();
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombre( rs.getString( "nombre" ) );
				bean.setRfc( rs.getString( "rfc" ) );
				bean.setTelefono2( rs.getString( "telefono2" ) );
				bean.setTelefono( rs.getString( "telefono" ) );
				bean.setEmail( rs.getString( "email" ) );
				bean.setIdCita( rs.getInt( "id_cita" ) );
				bean.setDireccion( rs.getString( "direccion" ) );
				bean.setIdTipoCliente( rs.getInt("id_tipo_cliente") );

				lista.add( bean );

			}
			con.close();

		} catch ( SQLException e ) {

			e.printStackTrace();

		}
		return lista;
		
	}

	
	public static boolean createNewUserInDB(ClienteBean bean) {

		boolean insertionFlag = false;
		String query = "INSERT INTO cliente ( nombre, rfc, persona, telefono, email, id_cita, direccion, id_tipo_cliente, condiciones) values (?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setString( 1, bean.getNombre() );
			ps.setString( 2, bean.getRfc() );
			ps.setString( 3, bean.getTelefono2() );
			ps.setString( 4, bean.getTelefono() );
			ps.setString( 5, bean.getEmail() );
			ps.setInt( 6, bean.getIdCita() );
			ps.setString( 7, bean.getDireccion() );
			ps.setInt( 8, bean.getIdTipoCliente() );
			insertionFlag = (ps.executeUpdate() == 1) ? true : false;

			con.close();
			
		} catch ( SQLException ex ) {

			ex.printStackTrace();

		}
		return insertionFlag;

	}

	public static boolean deleteCliente(int idCliente) {

		boolean insertionFlag = false;
		String query = "DELETE FROM cliente WHERE id_cliente = ?";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setInt( 1, idCliente );
			insertionFlag = ( ps.executeUpdate() == 1 ) ? true : false;
			con.close();
			
		} catch ( SQLException ex ) {

			ex.printStackTrace();

		}
		
		return insertionFlag;

	}
	*/

}
