package com.inventry.project.model;

import javax.persistence.*;

@Entity
public class Supportacquistion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reference;

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


	private String type;
	
	
	public Supportacquistion(String type) {
		//this.reference=reference;
		this.type=type;
	}
}
