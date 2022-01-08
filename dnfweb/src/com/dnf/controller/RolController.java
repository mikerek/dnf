package com.dnf.controller;

import java.util.ArrayList;

import com.dnf.db.bean.RolBean;
import com.dnf.db.dao.RolDAO;

public class RolController {
	
public static ArrayList< RolBean > getAllRoles( ) {
		
		ArrayList< RolBean > bean = new ArrayList< RolBean >();
		bean = RolDAO.getAllRoles();
		return bean;
		
	}

}
