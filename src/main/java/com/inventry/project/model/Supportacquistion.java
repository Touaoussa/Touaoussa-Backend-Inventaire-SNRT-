package com.inventry.project.model;

import javax.persistence.*;

@Entity
public class Supportacquistion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String reference;
	private String type;
	
	
	public Supportacquistion() {
		
	}
}
