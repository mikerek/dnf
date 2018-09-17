package com.umeni.controller;

import com.umeni.db.bean.UsuarioBean;
import com.umeni.db.dao.UsuarioDAO;

public class NewUserController {
	
	public static boolean createNewUser( UsuarioBean bean ) {
		
		boolean insertionFlag = false;
		insertionFlag = UsuarioDAO.createNewUserInDB( bean );
		return insertionFlag;
		
	}

}
