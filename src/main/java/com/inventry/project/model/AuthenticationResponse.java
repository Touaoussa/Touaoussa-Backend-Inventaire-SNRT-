package com.inventry.project.model;

public class AuthenticationResponse {
private final String jwt ;
private long expiration ;


public AuthenticationResponse(String jwt , long expiration) {
	this.jwt = jwt;
	this.expiration=expiration;
}

public String getJwt() {
	return jwt;
}

public long getExpiration() {
	return expiration;
}

public void setExpiration(long expiration) {
	this.expiration = expiration;
}



}
