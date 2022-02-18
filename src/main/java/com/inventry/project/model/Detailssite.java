package com.inventry.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Detailssite implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String Id_local;
	private String Intitule;
	private String Etage;
	private Integer Numetage;
	@ManyToOne
	@JoinColumn(name="site_id", nullable=false)
	@JsonBackReference
	private Site site;
	
	
	@OneToMany(mappedBy = "site" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
    List<Pvreception> pvs;
	
	public Detailssite() {
		super();
	}




	public Detailssite(String id_local, String intitule, String etage, Integer numetage, Site site) {
		super();
		Id_local = id_local;
		Intitule = intitule;
		Etage = etage;
		Numetage = numetage;
		this.site = site;
	}




	public Detailssite(String id_local, String intitule, String etage, Integer numetage, Site site,
			List<Pvreception> pvs) {
		super();
		Id_local = id_local;
		Intitule = intitule;
		Etage = etage;
		Numetage = numetage;
		this.site = site;
		this.pvs = pvs;
	}

	public Detailssite(String id_local, String intitule, String etage, Integer numetage, String site,
			List<Pvreception> pvs) {
		super();
		Id_local = id_local;
		Intitule = intitule;
		Etage = etage;
		Numetage = numetage;
		//this.site = site;
		this.pvs = pvs;
	}




	public String getId_local() {
		return Id_local;
	}




	public void setId_local(String id_local) {
		Id_local = id_local;
	}




	public String getIntitule() {
		return Intitule;
	}




	public void setIntitule(String intitule) {
		Intitule = intitule;
	}




	public String getEtage() {
		return Etage;
	}




	public void setEtage(String etage) {
		Etage = etage;
	}




	public Integer getNumetage() {
		return Numetage;
	}




	public void setNumetage(Integer numetage) {
		Numetage = numetage;
	}




	public Site getSite() {
		return this.site;
	}

	/*public void setSite(Site site) {
		this.site.setIntitule(site.getIntitule());
	}*/



	public void setSite(Site site) {
		this.site = site;
	}



	
	public List<Pvreception> getPvs() {
		return pvs;
	}




	public void setPvs(List<Pvreception> pvs) {
		this.pvs = pvs;
	}
	
	
	
	
	


}
