package com.dnf.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dnf.db.bean.VentaBean;
import com.dnf.db.connection.ConexBD;

public class VentaDAO {

	public static boolean registrarCompra(VentaBean ventaBean) {

		String query = "INSERT INTO venta (id_usuario, id_producto, venta, fecha, hora, comentarios) values (?,?,?,?,?, now(),?)";
		boolean bandera = false;
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, ventaBean.getId_usuario());
			ps.setInt(2, ventaBean.getId_producto());
			ps.setFloat(3, ventaBean.getVenta());
			ps.setString(4, ventaBean.getFecha());
			ps.setString(6, ventaBean.getComentarios());
			bandera = (ps.executeUpdate() == 1) ? true : false;

			con.close();
		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return bandera;
	}
}
