package com.bceden.encryption.md5;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public final class UserApi {
	
	private final static Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
	
	private UserApi () {
		
	}
	


	
	public static String encodePassword(String password) {
		return passwordEncoder.encodePassword(password,"hc360");
	}
	
	
	
}