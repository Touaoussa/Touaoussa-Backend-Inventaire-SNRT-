package com.inventry.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commanditaire {
	@Id
	private Long idcommanditaire;
	private String intitule;
	
	
	public Commanditaire() {
		super();
	}

	public Commanditaire(Long id_commanditaire, String intitule) {
		super();
		this.idcommanditaire = id_commanditaire;
		this.intitule = intitule;
	}

	public Long getIdcommanditaire() {
		return idcommanditaire;
	}

	public void setId_commanditaire(Long id_commanditaire) {
		this.idcommanditaire = id_commanditaire;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
	
	
	
}
