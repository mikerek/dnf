package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.umeni.db.bean.ProductoBean;
import com.umeni.db.connection.ConexBD;

public class PinturaDAO {
	
	public static boolean existeProducto( String idProducto ) {
		
		String query = "SELECT nombre FROM pintura WHERE nombre LIKE ?";
		boolean bandera = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			ps.setString(1, idProducto);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				
				bandera = true;
				
			}
			
		}
		catch( SQLException e ) {
			
			e.printStackTrace();
			
		}
		return bandera;
		
	}
	
	
	public static ArrayList< ProductoBean > obtenerPinturas( ) {
		
		String query = "SELECT id_producto, nombre, descripcion, precio, categoria, detalles, imagen, imagen2, imagen3 FROM pintura";
		ArrayList< ProductoBean > listaPinturas = new ArrayList< ProductoBean >();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try {
			
			ps = con.prepareStatement( query );
			rs = ps.executeQuery();
			while ( rs.next() ) {
				
				ProductoBean bean = new ProductoBean();
				bean.setId_producto( rs.getInt( "id_producto" ) );
				bean.setNombre( rs.getString( "nombre" ) );
				bean.setDescripcion( rs.getString( "descripcion" ) );
				bean.setPrecio( rs.getFloat( "precio" ) );
				bean.setId_categoria( rs.getInt( "categoria" ) );
				bean.setDetalles( rs.getString( "detalles" ) );
				bean.setImagen( rs.getString( "imagen" ) );
				bean.setImagen( rs.getString( "imagen2" ) );
				bean.setImagen( rs.getString( "imagen3" ) );
				
				listaPinturas.add( bean );
					
			}
			con.close();
			
		}
		catch( SQLException e ) {
			
			e.printStackTrace();
			
		}
		return listaPinturas;
		
	}

}
