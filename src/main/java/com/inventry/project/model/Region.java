package com.inventry.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Region {

	@Id 
	private Long id_region;
	private String Intitule;
	
	@OneToMany(mappedBy="region", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Site> sites;

	public Region() {
		
	}
	public Region(Long id_region, String intitule, List<Site> sites) {
		super();
		this.id_region = id_region;
		Intitule = intitule;
		this.sites = sites;
	}

	public Long getId_region() {
		return id_region;
	}

	public void setId_region(Long id_region) {
		this.id_region = id_region;
	}

	public String getIntitule() {
		return Intitule;
	}

	public void setIntitule(String intitule) {
		Intitule = intitule;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
}
