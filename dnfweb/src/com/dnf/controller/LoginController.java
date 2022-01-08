package com.dnf.controller;

import com.dnf.db.bean.UsuarioBean;
import com.dnf.db.dao.MenuGeneratorDAO;
import com.dnf.db.dao.UsuarioDAO;
import com.dnf.utils.HashEncryption;
import com.dnf.utils.RegexPatterns;

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
