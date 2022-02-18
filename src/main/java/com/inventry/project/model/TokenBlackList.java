package com.inventry.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TokenBlackList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long _id;
	@Column(length=500)
	private String token;
	
	public TokenBlackList() {
		super();
	}
		
	public TokenBlackList(Long _id, String token) {
		super();
		this._id = _id;
		this.token = token;
	}


	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
