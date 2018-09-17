package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umeni.db.bean.CompraBean;
import com.umeni.db.connection.ConexBD;

public class CompraDAO {
	
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

}
