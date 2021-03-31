package com.inventry.project.model;

import javax.persistence.*;

@Entity
public class Direction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddirection;
	
	private String intitule;
	private int nombrepersonnel; 
	public Direction() {
		
	}
	public  Direction(String intitule,int nombrepersonnel ) {
		this.intitule=intitule;
		this.nombrepersonnel =nombrepersonnel ; 
	}

	public int getNombrepersonnel() {
		return nombrepersonnel;
	}
	public void setNombrepersonnel(int nombrepersonnel) {
		this.nombrepersonnel = nombrepersonnel;
	}
	public Long getIddirection() {
		return iddirection;
	}

	public void setIddirection(Long iddirection) {
		this.iddirection = iddirection;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
}
