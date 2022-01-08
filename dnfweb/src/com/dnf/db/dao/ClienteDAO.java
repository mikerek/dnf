package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dnf.db.bean.ClienteBean;
import com.dnf.db.bean.UsuarioBean;
import com.dnf.db.connection.ConexBD;
import com.dnf.utils.HashEncryption;

public class ClienteDAO {
	
	public static ArrayList< ClienteBean > obtenerTodosLosClientes() {
		
		ArrayList< ClienteBean > lista = new ArrayList<ClienteBean>();
		String query = "SELECT id_cliente, nombre, rfc, persona, telefono, email, cargo, direccion, id_tipo_cliente, condiciones FROM cliente";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {

				ClienteBean bean = new ClienteBean();
				bean.setIdCliente( rs.getInt( "id_cliente" ) );
				bean.setNombre( rs.getString( "nombre" ) );
				bean.setRfc( rs.getString( "rfc" ) );
				bean.setPersona( rs.getString( "persona" ) );
				bean.setTelefono( rs.getString( "telefono" ) );
				bean.setEmail( rs.getString( "email" ) );
				bean.setCargo( rs.getString( "cargo" ) );
				bean.setDireccion( rs.getString( "direccion" ) );
				bean.setIdTipoCliente( rs.getInt("id_tipo_cliente") );
				bean.setCondiciones( rs.getString( "condiciones" ) );

				lista.add(bean);

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return lista;
		
	}
	
	public static ClienteBean obtenerCliente( int idCliente ) {
		
		ClienteBean bean = new ClienteBean();
		String query = "SELECT id_cliente, nombre, rfc, persona, telefono, email, cargo, direccion, id_tipo_cliente, condiciones FROM cliente WHERE id_cliente = ?";
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
				bean.setPersona( rs.getString( "persona" ) );
				bean.setTelefono( rs.getString( "telefono" ) );
				bean.setEmail( rs.getString( "email" ) );
				bean.setCargo( rs.getString( "cargo" ) );
				bean.setDireccion( rs.getString( "direccion" ) );
				bean.setIdTipoCliente( rs.getInt("id_tipo_cliente") );
				bean.setCondiciones( rs.getString( "condiciones" ) );

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return bean;
		
	}
	
	public static ArrayList< ClienteBean > obtenerTodosLosClientesByTipo( int idTipoCliente ) {
		
		ArrayList< ClienteBean > lista = new ArrayList<ClienteBean>();
		String query = "SELECT id_cliente, nombre, rfc, persona, telefono, email, cargo, direccion, id_tipo_cliente, condiciones FROM cliente WHERE id_tipo_cliente = ?";
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
				bean.setPersona( rs.getString( "persona" ) );
				bean.setTelefono( rs.getString( "telefono" ) );
				bean.setEmail( rs.getString( "email" ) );
				bean.setCargo( rs.getString( "cargo" ) );
				bean.setDireccion( rs.getString( "direccion" ) );
				bean.setIdTipoCliente( rs.getInt("id_tipo_cliente") );
				bean.setCondiciones( rs.getString( "condiciones" ) );

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
		String query = "INSERT INTO cliente ( nombre, rfc, persona, telefono, email, cargo, direccion, id_tipo_cliente, condiciones) values (?,?,?,?,?,?,?,?,?) ";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setString( 1, bean.getNombre() );
			ps.setString( 2, bean.getRfc() );
			ps.setString( 3, bean.getPersona() );
			ps.setString( 4, bean.getTelefono() );
			ps.setString( 5, bean.getEmail() );
			ps.setString( 6, bean.getCargo() );
			ps.setString( 7, bean.getDireccion() );
			ps.setInt( 8, bean.getIdTipoCliente() );
			ps.setString( 9, bean.getCondiciones() );
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

}
