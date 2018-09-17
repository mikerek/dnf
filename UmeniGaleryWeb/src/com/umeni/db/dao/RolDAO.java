package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.umeni.db.bean.RolBean;
import com.umeni.db.connection.ConexBD;

public class RolDAO {

public static ArrayList< RolBean > getAllRoles( ){
		
		String query="SELECT id_rol, nombre FROM rol";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		ArrayList< RolBean > beanList = new ArrayList< RolBean >();
 		
		try {
			ps = con.prepareStatement( query );	
			rs = ps.executeQuery();
			while( rs.next() ) {
				
				RolBean bean = new RolBean();
				bean.setId_rol( rs.getInt( "id_rol" ) );
				bean.setNombre( rs.getString( "nombre" ) );
				beanList.add( bean );
				
			}
			con.close();
		} 
		catch (SQLException e) {
			
			System.out.println( "Hubo un error en la base de datos: " );
			e.printStackTrace();
			
		}	
		return beanList;
		
	}

}
