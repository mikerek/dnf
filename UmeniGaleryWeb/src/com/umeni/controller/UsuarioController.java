package com.umeni.controller;

import java.util.ArrayList;

import com.umeni.db.bean.UsuarioBean;
import com.umeni.db.dao.UsuarioDAO;

public class UsuarioController {

	public UsuarioBean getAllDataFromUserByName(String nombreUsuario) {

		UsuarioBean bean = new UsuarioBean();
		UsuarioDAO dao = new UsuarioDAO();
		return bean = dao.getDataFromUserByName(nombreUsuario);

	}

	public static UsuarioBean getAllDataFromUserByIdUser(int idUserName) {

		UsuarioBean bean = new UsuarioBean();
		UsuarioDAO dao = new UsuarioDAO();
		return bean = dao.getDataFromUserByIdUser(idUserName);

	}

	public static ArrayList<UsuarioBean> getAllUsers() {

		ArrayList<UsuarioBean> userList = new ArrayList<UsuarioBean>();
		userList = UsuarioDAO.getAllUsers();
		return userList;

	}

	public static boolean deleteUser(int idUsuario) {

		boolean eliminado = false;
		eliminado = UsuarioDAO.deleteUserInDB(idUsuario);
		return eliminado;

	}

	public static boolean changeUser(UsuarioBean bean) {

		boolean cambiado = false;
		cambiado = UsuarioDAO.changeUser(bean);
		return cambiado;

	}
}
