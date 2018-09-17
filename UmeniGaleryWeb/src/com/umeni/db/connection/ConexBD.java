package com.umeni.db.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexBD {

	public static Connection getConnection(){
		
		Context cont = null;
		DataSource ds = null;
		Connection con = null;
		try {
			
			if(cont == null ) {
				InitialContext iniCont = new InitialContext();
				cont = (Context) iniCont.lookup("java:comp/env");
				ds = (DataSource) cont.lookup("jdbc/umeni");
				con = ds.getConnection();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
}
