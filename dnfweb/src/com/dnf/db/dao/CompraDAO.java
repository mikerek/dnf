package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dnf.db.bean.CompraBean;
import com.dnf.db.connection.ConexBD;

public class CompraDAO {
	
	/*
	public static boolean registrarCompra( CompraBean compraBean ) {
		
		String query = "INSERT INTO compras (id_usuario, compra, fecha, hora, comentarios) values (?,?,?,?, now(),?)";
		boolean bandera = false;
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			ps = con.prepareStatement( query );
			ps.setInt( 1, compraBean.getId_usuario() );
			ps.setFloat( 2 , compraBean.getCompra() );
			ps.setString( 3 , compraBean.getFecha() );
			ps.setString( 4 , compraBean.getComentarios() );
			bandera = (ps.executeUpdate() == 1 ) ? true : false;
			
			con.close();
		}
		catch ( SQLException ex ) {
			
			ex.printStackTrace();
			
		}
		
		return bandera;
		
	}
	*/
	
	public static ArrayList<CompraBean> obtenerTodasLasCompras() {
		
		String query = "SELECT id_compra, id_articulo, cantidad, precio_unitario, precio_total, detalles_compra, id_usuario, fecha_compra FROM compras";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		ArrayList<CompraBean> lista = new ArrayList<CompraBean>();
		try {
			ps = con.prepareStatement( query );
			rs = ps.executeQuery();
			while ( rs.next() ) {
				
				CompraBean bean = new CompraBean();
				bean.setId_compra( rs.getInt( "id_compra" ) );
				bean.setId_articulo( rs.getInt( "id_articulo" ) );
				bean.setId_usuario( rs.getInt( "id_usuario" ) );
				bean.setCantidad( rs.getInt( "cantidad" ) );
				bean.setDetalles_compra( rs.getString( "detalles_compra" ) );
				bean.setFecha_compra( rs.getString( "fecha_compra" ) );
				bean.setPrecio_total( rs.getString( "precio_total" ) );
				bean.setPrecio_unitario( rs.getString( "precio_unitario" ) );
				lista.add( bean );
				
			}
			
		}
		catch( Exception e ) {
			
			e.printStackTrace();
			
		}
		return lista;
		
	}

}
