package com.umeni.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.umeni.db.bean.UsuarioBean;
import com.umeni.db.connection.ConexBD;
import com.umeni.utils.HashEncryption;

/**
 * En toda la clase se registraron cambios a los queries.
 * 
 * @author Miguel Rdz
 * @date 12/03/14
 *
 */
public class UsuarioDAO {

	public static UsuarioBean getDataFromUserByName(String nombre) {

		String query = "SELECT id_usuario, nombre, email, password, id_rol FROM usuario WHERE email = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		UsuarioBean bean = new UsuarioBean();

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, nombre);
			rs = ps.executeQuery();
			while (rs.next()) {

				bean.setId_Usuario(rs.getInt("id_usuario"));
				bean.setNombre(rs.getString("nombre"));
				bean.setEmail( rs.getString( "email" ) );
				bean.setPassword(rs.getString("password"));
				bean.setId_Rol(rs.getInt("id_rol"));

			}
			con.close();
		} catch (SQLException e) {

			System.out.println("Hubo un error en la base de datos: ");
			e.printStackTrace();

		}
		return bean;

	}

	public static UsuarioBean getDataFromUserByIdUser(int IdUser) {

		String query = "SELECT id_usuario, nombre, email, password, id_rol FROM usuario WHERE id_usuario = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		UsuarioBean bean = new UsuarioBean();

		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, IdUser);
			rs = ps.executeQuery();
			while (rs.next()) {

				bean.setId_Usuario(rs.getInt("id_usuario"));
				bean.setNombre(rs.getString("nombre"));
				bean.setEmail( rs.getString( "email" ) );
				bean.setPassword(rs.getString( "password" ));
				bean.setId_Rol(rs.getInt("id_rol"));

			}
			con.close();
		} catch (SQLException e) {

			System.out.println("Hubo un error en la base de datos: ");
			e.printStackTrace();

		}
		return bean;

	}

	public static int usersInDatabase(String nombreUsuario) {

		String query = "SELECT count(1) FROM usuario WHERE email = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		int numberOfUsers = 0;
		try {

			ps = con.prepareStatement(query);
			ps.setString(1, nombreUsuario);
			rs = ps.executeQuery();
			while (rs.next()) {

				numberOfUsers = rs.getInt(1);

			}
			con.close();

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return numberOfUsers;
	}

	public static String passwordForUser(String nombreUsuario) {

		String query = "SELECT password FROM usuario WHERE email = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();
		String passwordFromDB = "";
		try {

			ps = con.prepareStatement(query);
			ps.setString(1, nombreUsuario);
			rs = ps.executeQuery();
			while (rs.next()) {

				passwordFromDB = rs.getString(1);
				// System.out.println("Password from DB: " + passwordFromDB);

			}
			con.close();
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return passwordFromDB;
	}

	public static boolean createNewUserInDB(UsuarioBean bean) {

		boolean insertionFlag = false;
		String query = "INSERT INTO usuario (nombre, password, email, id_rol) values (?,?,?,?) ";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			ps.setString(2, HashEncryption.md5Java(bean.getPassword()));
			ps.setString(3, bean.getEmail());
			ps.setInt(4, bean.getId_Rol());
			insertionFlag = (ps.executeUpdate() == 1) ? true : false;

			con.close();
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return insertionFlag;

	}

	public static boolean deleteUserInDB(int idUsuario) {

		boolean insertionFlag = false;
		String query = "DELETE FROM usuario WHERE id_usuario = ?";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, idUsuario);
			insertionFlag = (ps.executeUpdate() == 1) ? true : false;
			con.close();
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return insertionFlag;

	}

	public static ArrayList<UsuarioBean> getAllUsers() {

		String query = "SELECT id_usuario, nombre, password, id_rol, email FROM usuario";
		ArrayList<UsuarioBean> userList = new ArrayList<UsuarioBean>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = ConexBD.getConnection();

		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {

				UsuarioBean bean = new UsuarioBean();
				bean.setId_Usuario(rs.getInt("id_usuario"));
				bean.setNombre(rs.getString("nombre"));
				bean.setPassword(rs.getString("password"));
				bean.setId_Rol(rs.getInt("id_rol"));
				bean.setEmail(rs.getString("email"));
				userList.add(bean);

			}
			con.close();
		} catch (SQLException e) {

			System.out.println("Hubo un error en la base de datos: ");
			e.printStackTrace();

		}
		return userList;

	}

	public static boolean changeUser(UsuarioBean bean) {

		boolean updateFlag = false;
		String query = "UPDATE usuario SET nombre = ?, password = ?, email = ?, id_rol = ? WHERE id_usuario = ?";
		PreparedStatement ps = null;
		Connection con = ConexBD.getConnection();
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			ps.setString(2, HashEncryption.md5Java(bean.getPassword()));
			ps.setString(3, bean.getEmail());
			ps.setInt(4, bean.getId_Rol());
			updateFlag = (ps.executeUpdate() == 1) ? true : false;

			con.close();
		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		return updateFlag;
	}

}
