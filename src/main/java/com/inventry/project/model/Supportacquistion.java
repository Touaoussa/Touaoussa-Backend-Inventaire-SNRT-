package com.inventry.project.model;

import javax.persistence.*;

@Entity
public class Supportacquistion {
	
	@Id
	private Long reference;
	private String type;

	public Supportacquistion(Long reference, String type) {
		this.reference = reference;
		this.type = type;
	}

	public Supportacquistion() {
		
	}
	
	public Long getReference() {
		return reference;
	}


	public void setReference(Long reference) {
		this.reference = reference;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	

}
