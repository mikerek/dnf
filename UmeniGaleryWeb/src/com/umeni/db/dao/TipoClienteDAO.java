package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.umeni.db.bean.TipoClienteBean;
import com.umeni.db.connection.ConexBD;

public class TipoClienteDAO {

	public static ArrayList<TipoClienteBean> obtenerTiposCliente() {

		String query = "SELECT id_tipo_cliente, tipo, descripcion FROM tipo_cliente";
		ArrayList<TipoClienteBean> lista = new ArrayList<TipoClienteBean>();
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {

			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {

				TipoClienteBean bean = new TipoClienteBean();
				bean.setIdTipoCliente(rs.getInt("id_tipo_cliente"));
				bean.setTipo(rs.getString("tipo"));
				bean.setDescripcion(rs.getString("descripcion"));

				lista.add(bean);

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return lista;

	}

	public static TipoClienteBean obtenerTipoCliente( int idTipoCliente ) {

		String query = "SELECT id_tipo_cliente, tipo, descripcion FROM tipo_cliente WHERE ?";
		TipoClienteBean bean = new TipoClienteBean();
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		ResultSet rs = null;
		try {

			ps = con.prepareStatement( query );
			ps.setInt( 1, idTipoCliente );
			rs = ps.executeQuery();
			while ( rs.next() ) {

				bean.setIdTipoCliente( rs.getInt( "id_tipo_cliente" ) );
				bean.setTipo( rs.getString( "tipo" ) );
				bean.setDescripcion(rs.getString("descripcion"));

			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return bean;

	}

}
