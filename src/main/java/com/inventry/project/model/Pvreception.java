package com.inventry.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pvreception {
	
	@Id
	private String numpv;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String date_pv;
	private String utilisateur;
	
	@ManyToMany
	@JoinTable(
			  name = "agentspv", 
			  joinColumns = @JoinColumn(name = "pv_id"), 
			  inverseJoinColumns = @JoinColumn(name = "agent_id"))
	private List<Utilisateur> agents;
	
	
	
	@ManyToOne
	@JoinColumn(name="reception_id", nullable=false)	
	private Reception reception;
	
	@ManyToOne
	@JoinColumn(name="bonlivraison_id", nullable=false)	
	private BonLivraison bonlivraison;
	
	public Pvreception() {
		
	}
	
	public Pvreception(String numpv, String date_pv, String utilisateur, List<Utilisateur> agents, Reception reception) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.agents = agents;
		this.reception = reception;
	}




	public Pvreception(String numpv, String date_pv, String utilisateur, List<Utilisateur> agents, Reception reception,
			BonLivraison bonlivraison) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.agents = agents;
		this.reception = reception;
		this.bonlivraison = bonlivraison;
	}

	public String getNumpv() {
		return numpv;
	}

	public void setNumpv(String numpv) {
		this.numpv = numpv;
	}

	
	public List<Utilisateur> getAgents() {
		return agents;
	}

	@JsonProperty
	public void setAgents(List<Utilisateur> agents) {
		this.agents = agents;
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
	

	public Reception getReception() {
		return reception;
	}
	@JsonProperty
	public void setReception(Reception reception) {
		this.reception = reception;
	}

	@JsonIgnore
	public BonLivraison getBonlivraison() {
		return bonlivraison;
	}

	@JsonProperty
	public void setBonlivraison(BonLivraison bonlivraison) {
		this.bonlivraison = bonlivraison;
	}
	
	
	
}
