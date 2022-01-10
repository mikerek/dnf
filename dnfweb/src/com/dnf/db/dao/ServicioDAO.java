package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dnf.db.bean.ServicioBean;
import com.dnf.db.connection.ConexBD;

public class ServicioDAO {
	
	public static ArrayList< ServicioBean > obtenerTodosLosServicios() {
	      
	      ArrayList< ServicioBean > lista = new ArrayList<ServicioBean>();
	      String query = "SELECT id_servicio, servicio, descripcion, precio, duracion FROM servicio";
	      PreparedStatement ps = null;
	      Connection con = ConexBD.getConnection();
	      ResultSet rs = null;
	      try {

	        ps = con.prepareStatement( query );
	        rs = ps.executeQuery();
	        while ( rs.next() ) {

	          ServicioBean bean = new ServicioBean();
	          bean.setIdServicio( rs.getInt( "id_servicio" ) );
	          bean.setServicio( rs.getString( "servicio" ) );
	          bean.setDescripcion( rs.getString( "descripcion" ) );
	          bean.setPrecio( rs.getString( "precio" ) );
	          bean.setDuracion( rs.getString( "duracion" ) );
	          lista.add( bean );

	        }
	        con.close();

	      } catch (SQLException e) {

	        e.printStackTrace();

	      }
	      return lista;
	      
	    }

}
