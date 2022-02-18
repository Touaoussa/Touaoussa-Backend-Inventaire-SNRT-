package com.inventry.project.DTO;

import java.util.List;

import javax.persistence.Id;

import com.inventry.project.model.Detailssite;
import com.inventry.project.model.Region;
import com.inventry.project.model.Utilisateur;

public class SiteDto {

	private Long codification;
	private String intitule;
	private String localite;
	private String adresse;
	private String cordonneesgps;
	private Region region;
	private Utilisateur utilisateur;
	List<Detailssite> detailssite;
	public SiteDto() {
		super();
	}

	public SiteDto(Long codification, String intitule, String localite, String adresse, String cordonneesgps,
			Region region, Utilisateur utilisateur) {
		super();
		this.codification = codification;
		this.intitule = intitule;
		this.localite = localite;
		this.adresse = adresse;
		this.cordonneesgps = cordonneesgps;
		this.region = region;
		this.utilisateur = utilisateur;
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
	
	public List<Detailssite> getDetailssite() {
		return detailssite;
	}




	public void setDetailssite(List<Detailssite> detailssite) {
		this.detailssite = detailssite;
	}

	
}
