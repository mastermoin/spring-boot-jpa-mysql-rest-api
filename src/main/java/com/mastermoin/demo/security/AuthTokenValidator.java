package com.mastermoin.demo.security;

public class AuthTokenValidator {
	
	public boolean isValid (String token) {
		if (token == null) {
			return false;
		}
		return true;
	}

}
