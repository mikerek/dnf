package com.umeni.utilities;

import com.google.gson.Gson;
import com.umeni.db.bean.UsuarioBean;

public class POJOtoGsonConverter {
	
	public static Gson convertUsuarioBean( UsuarioBean bean ) {
		Gson gsonObject = new Gson();
		gsonObject.toJson( bean );
		return gsonObject;
	}

}
