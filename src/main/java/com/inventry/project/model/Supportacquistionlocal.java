package com.inventry.project.model;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
public class Supportacquistionlocal {
	
	@Id
	private Long reference;
	@Column
	private String type;

	public Supportacquistionlocal(Long reference, String type) {
		this.reference = reference;
		this.type = type;
	}

	public Supportacquistionlocal() {
		
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

