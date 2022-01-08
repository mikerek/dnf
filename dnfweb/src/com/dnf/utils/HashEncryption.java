package com.dnf.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashEncryption {

	public static String md5Java( String mensaje ) {
		
		String digest = null; 
		try { 
			
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] hash = md.digest(mensaje.getBytes("UTF-8")); 
			
			//converting byte array to Hexadecimal 
			StringBuilder sb = new StringBuilder(2*hash.length); 
			for( byte b : hash ) {
				
				sb.append( String.format( "%02x", b&0xff ) );
				
			} 
			digest = sb.toString();
			
		} 
		catch ( UnsupportedEncodingException ex ) {
			
			ex.printStackTrace();
			
		} 
		catch ( NoSuchAlgorithmException ex ) {
			
			ex.printStackTrace();
			
		} 
		return digest;
		
	}

}
