package com.inventry.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pvreception {
	
	@Id
	private Long numpv;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String date_pv;
	private String utilisateur;
	
	@ManyToOne
	@JoinColumn(name="agent_id", nullable=false)	
	private Utilisateur agent;
	
	
	
	@ManyToOne
	@JoinColumn(name="reception_id", nullable=false)	
	private Reception reception;
	
	
	
	public Pvreception() {
		
	}
	
	public Pvreception(Long numpv, String date_pv, String utilisateur, Utilisateur agent, Reception reception) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.agent = agent;
		this.reception = reception;
	}









	public Long getNumpv() {
		return numpv;
	}

	public void setNumpv(Long numpv) {
		this.numpv = numpv;
	}

	@JsonIgnore
	public Utilisateur getAgent() {
		return agent;
	}

	@JsonProperty
	public void setAgent(Utilisateur agent) {
		this.agent = agent;
	}


	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getDate_pv() {
		return date_pv;
	}

	public void setDate_pv(String date_pv) {
		this.date_pv = date_pv;
	}
	
	@JsonIgnore
	public Reception getReception() {
		return reception;
	}
	@JsonProperty
	public void setReception(Reception reception) {
		this.reception = reception;
	}
	
}
