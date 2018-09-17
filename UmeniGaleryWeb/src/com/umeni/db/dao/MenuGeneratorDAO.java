package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umeni.db.connection.ConexBD;

public class MenuGeneratorDAO {

public static String menuGeneratorFromDB( String nombreUsuario ) {
		
		String menuFromDB = "";
		String query="SELECT perm.descripcion, perm.url as link FROM permiso perm " +
				"LEFT JOIN rol_permiso rp ON rp.id_permiso = perm.id_permiso " +
				"LEFT JOIN rol ro ON ro.id_rol = rp.id_rol " +
				"LEFT JOIN usuario usr ON usr.id_rol = ro.id_rol " +
				"WHERE usr.email = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		try{
			
			ps = con.prepareStatement( query );
			ps.setString( 1, nombreUsuario );
			rs = ps.executeQuery();
			while ( rs.next() ) {
				
				menuFromDB += "<a href='" + rs.getString( "link" ) + "'>" + rs.getString( 1 ) + "</a>";
				menuFromDB += "&nbsp; | &nbsp;";
				
			}
			con.close();
			
		}
		catch ( SQLException ex ) {
			
			ex.printStackTrace();
			
		}
		return menuFromDB;
	}
	
	
}
