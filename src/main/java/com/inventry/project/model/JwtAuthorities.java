package com.inventry.project.model;

public class JwtAuthorities {
String jwt ;

public JwtAuthorities() {
	super();
}

public JwtAuthorities(String jwt) {
	super();
	this.jwt = jwt;
}

public String getJwt() {
	return jwt;
}

public void setJwt(String jwt) {
	this.jwt = jwt;
}


}
