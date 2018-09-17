package com.umeni.utils;

public class RegexPatterns {
	
	public static final String VALID_EMAIL_ADDRESS_REGEX = 
		    //Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			 "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	
	public static boolean evalEmail( String toEvaluate ) {
		
		boolean flag = false;
		if( toEvaluate.matches( VALID_EMAIL_ADDRESS_REGEX ) ) {
			flag = true;
			
		}
		return flag;
		
	}

}
