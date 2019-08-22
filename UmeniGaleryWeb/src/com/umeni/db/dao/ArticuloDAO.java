package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.umeni.db.bean.ArticuloBean;

import com.umeni.db.connection.ConexBD;

public class ArticuloDAO {
	
	public static ArrayList< ArticuloBean > obtenerTodosLosArticulos() {
		
		ArrayList< ArticuloBean > lista = new ArrayList<ArticuloBean>();
		String query = "SELECT id_articulo, id_articulo_tipo, id_articulo_categoria, descripcion FROM articulo";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {

				ArticuloBean bean = new ArticuloBean();
				bean.setId_articulo( rs.getInt( "id_articulo" ));
				bean.setId_articulo_tipo( rs.getInt( "id_articulo_tipo" ));
				bean.setId_articulo_categoria( rs.getInt( "id_articulo_categoria" ));
				bean.setDescripcion( rs.getString( "descripcion" ) );

				lista.add( bean );

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return lista;
		
	}

}
