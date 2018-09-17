package com.umeni.controller;

import java.util.ArrayList;

import com.umeni.db.bean.RolBean;
import com.umeni.db.dao.RolDAO;

public class RolController {
	
public static ArrayList< RolBean > getAllRoles( ) {
		
		ArrayList< RolBean > bean = new ArrayList< RolBean >();
		bean = RolDAO.getAllRoles();
		return bean;
		
	}

}
