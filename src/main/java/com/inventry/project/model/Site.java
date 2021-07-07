package com.inventry.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Site implements Serializable {

	@Id
	private Long codification;
	private String intitule;
	private String localite;
	private String adresse;
	private String cordonneesgps;
	@ManyToMany(mappedBy="sites",cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Supportacquistion> supports;
	



	public Site(Long codification, String intitule, String localite, String adresse, String cordonneesgps,
			List<Supportacquistion> supports) {
		super();
		this.codification = codification;
		this.intitule = intitule;
		this.localite = localite;
		this.adresse = adresse;
		this.cordonneesgps = cordonneesgps;
		this.supports = supports;
	}

	public Site() {
		
	}
	
	public Site(Long codification, String intitule, String localite, String adresse, String cordonneesgps) {
		super();
		this.codification = codification;
		this.intitule = intitule;
		this.localite = localite;
		this.adresse = adresse;
		this.cordonneesgps = cordonneesgps;
	}
	
	public Long getCodification() {
		return codification;
	}
	public void setCodification(Long codification) {
		this.codification = codification;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCordonneesgps() {
		return cordonneesgps;
	}
	public void setCordonneesgps(String cordonneesgps) {
		this.cordonneesgps = cordonneesgps;
	}
	
	public List<Supportacquistion> getSupports() {
		return supports;
	}

	public void setSupports(List<Supportacquistion> supports) {
		this.supports = supports;
	}
	
}
