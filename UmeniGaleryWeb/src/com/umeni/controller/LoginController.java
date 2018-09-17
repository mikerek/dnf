package com.umeni.controller;

import com.umeni.db.bean.UsuarioBean;
import com.umeni.db.dao.MenuGeneratorDAO;
import com.umeni.db.dao.UsuarioDAO;
import com.umeni.utils.HashEncryption;
import com.umeni.utils.RegexPatterns;

public class LoginController {
	
	public static boolean existingUser( String nombreUsuario ) {
		boolean flag = false;
		if( UsuarioDAO.usersInDatabase( nombreUsuario ) == 1) {
			
			flag = true;
			
		}
		return flag;
	}
	
	public static boolean correctPassword( String nombreUsuario, String passwordUsuario ) {
		boolean flag = false;
		String hashedPassword = HashEncryption.md5Java( passwordUsuario );
		//System.out.println("Tenemos el hash del password: " + hashedPassword );
		
		if( UsuarioDAO.passwordForUser( nombreUsuario ).equals( hashedPassword )) {
			
			flag = true;
			
		}
		return flag;
	}
	
	public static UsuarioBean getAllDataFromUser( String nombreUsuario ) {
		
		UsuarioBean bean = new UsuarioBean();
		bean = UsuarioDAO.getDataFromUserByName( nombreUsuario );
		return bean;
		
	}
	
	public static String menuGenerator( String nombreUsuario ) {

		return MenuGeneratorDAO.menuGeneratorFromDB( nombreUsuario );
		
	}
	
	public static boolean emailFormationEvaluation( String toEvaluate ) {
		
		boolean flag = false;
		if( RegexPatterns.evalEmail( toEvaluate ) ) {
			
			flag = true;
			
		}
		return flag;
		
	}

}
