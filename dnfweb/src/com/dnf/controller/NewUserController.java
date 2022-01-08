package com.dnf.controller;

import com.dnf.db.bean.UsuarioBean;
import com.dnf.db.dao.UsuarioDAO;

public class NewUserController {
	
	public static boolean createNewUser( UsuarioBean bean ) {
		
		boolean insertionFlag = false;
		insertionFlag = UsuarioDAO.createNewUserInDB( bean );
		return insertionFlag;
		
	}

}
