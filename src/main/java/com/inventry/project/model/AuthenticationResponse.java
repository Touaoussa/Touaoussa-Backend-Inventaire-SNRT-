package com.inventry.project.model;

public class AuthenticationResponse {
private final String jwt ;
private long expiration ;
private String username;

public AuthenticationResponse(String jwt , long expiration) {
	this.jwt = jwt;
	this.expiration=expiration;
}



public AuthenticationResponse(String jwt, long expiration, String username) {
	super();
	this.jwt = jwt;
	this.expiration = expiration;
	this.username = username;
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

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}





}
