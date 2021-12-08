package com.inventry.project.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Reception implements Serializable {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_reception;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String date_reception;
	private String type_reception;
	
	@ManyToOne
	@JoinColumn(name="support_id", nullable=true)
	private Supportacquistion supportacqisition;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable=true)
	private Site site;
	
	
	@OneToMany(mappedBy = "reception", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    List<Livraison> livraisons;
	


	
	
	public Reception(Long id_reception, String date_reception, String type_reception,
			Supportacquistion supportacqisition, Site site, List<Livraison> livraisons) {
		super();
		this.id_reception = id_reception;
		this.date_reception = date_reception;
		this.type_reception = type_reception;
		this.supportacqisition = supportacqisition;
		this.site = site;
		this.livraisons = livraisons;
	}


	
	
	




	
	public Site getSite() {
		return site;
	}


	
	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	
	
	public Reception() {
		
	}
	
	

	public Reception(Long id_reception, String date_reception, String type_reception) {
		super();
		this.id_reception = id_reception;
		this.date_reception = date_reception;
		this.type_reception = type_reception;
	}

	


	public List<Livraison> getLivraisons() {
		return livraisons;
	}



	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}



	public Reception(Long id_reception, String date_reception, String type_reception,
			Supportacquistion supportacqisition) {
		super();
		this.id_reception = id_reception;
		this.date_reception = date_reception;
		this.type_reception = type_reception;
		this.supportacqisition = supportacqisition;
	}
	
	public Reception( String date_reception, String type_reception,Supportacquistion supportacqisition) {
	
		this.date_reception = date_reception;
		this.type_reception = type_reception;
		this.supportacqisition = supportacqisition;
	}


	public Long getId_reception() {
		return id_reception;
	}

	public void setId_reception(Long id_reception) {
		this.id_reception = id_reception;
	}

	public String getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(String date_reception) {
		this.date_reception = date_reception;
	}
	@JsonIgnore
	public String getType_reception() {
		return type_reception;
	}
	@JsonProperty
	public void setType_reception(String type_reception) {
		this.type_reception = type_reception;
	}
	
	@JsonIgnore
	public Supportacquistion getSupportacqisition() {
		return supportacqisition;
	}
	@JsonProperty
	public void setSupportacqisition(Supportacquistion supportacqisition) {
		this.supportacqisition = supportacqisition;
	}
	
		

}
