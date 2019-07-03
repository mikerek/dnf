package com.umeni.controller;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.umeni.db.bean.UsuarioBean;
import com.umeni.db.dao.UsuarioDAO;

public class UsuarioController {

	public UsuarioBean getAllDataFromUserByName(String nombreUsuario) {

		return UsuarioDAO.getDataFromUserByName(nombreUsuario);

	}
	
	public static String getAllDataFromUserJSONById( int idUserName ) {

		Gson gsonObject = new Gson();
		UsuarioBean bean = new UsuarioBean();
		bean = UsuarioDAO.getDataFromUserByIdUser( idUserName );
		return gsonObject.toJson( bean );

	}

	public static UsuarioBean getAllDataFromUserByIdUser(int idUserName) {

		return UsuarioDAO.getDataFromUserByIdUser(idUserName);

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
