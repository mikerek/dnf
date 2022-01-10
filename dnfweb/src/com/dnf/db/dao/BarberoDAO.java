package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dnf.db.bean.BarberoBean;
import com.dnf.db.connection.ConexBD;


public class BarberoDAO {

	public static ArrayList< BarberoBean > obtenerTodosLosBarberos() {
	    
	    ArrayList< BarberoBean > lista = new ArrayList<BarberoBean>();
	    String query = "SELECT id_barbero, nombre, telefono, id_sucursal FROM barbero";
	    PreparedStatement ps = null;
	    Connection con = ConexBD.getConnection();
	    ResultSet rs = null;
	    try {

	      ps = con.prepareStatement(query);
	      rs = ps.executeQuery();
	      while (rs.next()) {

	        BarberoBean bean = new BarberoBean();
	        bean.setIdBarbero( rs.getInt( "id_barbero" ) );
	        bean.setNombre( rs.getString( "nombre" ) );
	        bean.setTelefono( rs.getString( "telefono" ) );
	        bean.setIdSucursal( rs.getInt("id_sucursal") );

	        lista.add(bean);

	      }
	      con.close();

	    } catch (SQLException e) {

	      e.printStackTrace();

	    }
	    return lista;
	    
	  }
	
}
