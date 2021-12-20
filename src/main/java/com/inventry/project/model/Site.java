package com.inventry.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Site implements Serializable {

	@Id
	private Long codification;
	private String intitule;
	private String localite;
	private String adresse;
	private String cordonneesgps;
	@ManyToMany(mappedBy="sites",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Supportacquistion> supports;
	
	
	@OneToMany(mappedBy="site",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Reception> receptions;


	@ManyToOne
	@JoinColumn(name="region_id", nullable=false)
	@JsonIgnore
	private Region region;
	
	

	@ManyToOne
	@JoinColumn(name="responsable_id")
	@JsonIgnore
	private Utilisateur utilisateur;
	
	
	
	
	@OneToMany(mappedBy="site",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Detailssite> detailssite;
	
	
	
	
	
	
	
	
	
	public Site(Long codification, String intitule, String localite, String adresse, String cordonneesgps,
			List<Supportacquistion> supports, List<Reception> receptions, Region region, Utilisateur utilisateur, List<Detailssite> detailssite) {
		super();
		this.codification = codification;
		this.intitule = intitule;
		this.localite = localite;
		this.adresse = adresse;
		this.cordonneesgps = cordonneesgps;
		this.supports = supports;
		this.receptions = receptions;
		this.region = region;
		this.utilisateur = utilisateur;
		this.detailssite = detailssite;
	}




	

	public List<Reception> getReceptions() {
		return receptions;
	}

	public void setReceptions(List<Reception> receptions) {
		this.receptions = receptions;
	}




	public Site() {
		
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
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	/*public List<Pvreception> getPvs() {
		return pvs;
	}

	public void setPvs(List<Pvreception> pvs) {
		this.pvs = pvs;
	}*/




	public List<Detailssite> getDetailssite() {
		return detailssite;
	}




	public void setDetailssite(List<Detailssite> detailssite) {
		this.detailssite = detailssite;
	}

	
	
}
