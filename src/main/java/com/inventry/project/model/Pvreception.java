package com.inventry.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pvreception implements Serializable{
	
	/**
	 * 
	 */
	
	@Id
	private String numpv;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String date_pv;
	private String utilisateur;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			  name = "agentspv", 
			  joinColumns = @JoinColumn(name = "pv_id"), 
			  inverseJoinColumns = @JoinColumn(name = "agent_id"))
	private List<Utilisateur> agents;
	
	
	
	@ManyToOne
	@JoinColumn(name="support_id")	
	private Supportacquistion support;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable=false)	
	private Site site;
	
	@ManyToOne
	@JoinColumn(name="bonlivraison_id", nullable=false)	
	private BonLivraison bonlivraison;
	
	@ManyToMany(mappedBy = "pvs" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    List<Article> articles;
	
	public Pvreception() {
		
	}
	

	public Pvreception(String numpv, String date_pv, String utilisateur, List<Utilisateur> agents,
			Supportacquistion support, Site site, BonLivraison bonlivraison) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.agents = agents;
		this.support = support;
		this.site = site;
		this.bonlivraison = bonlivraison;
	}
	
	

	public Pvreception(String numpv, String date_pv, String utilisateur, List<Utilisateur> agents,
			Supportacquistion support, Site site, BonLivraison bonlivraison, List<Article> articles) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.agents = agents;
		this.support = support;
		this.site = site;
		this.bonlivraison = bonlivraison;
		this.articles = articles;
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

	//@JsonIgnore
	public BonLivraison getBonlivraison() {
		return bonlivraison;
	}

	//@JsonProperty
	public void setBonlivraison(BonLivraison bonlivraison) {
		this.bonlivraison = bonlivraison;
	}

	
	//@JsonIgnore
	public Supportacquistion getSupport() {
		return support;
	}

	@JsonProperty
	public void setSupport(Supportacquistion support) {
		this.support = support;
	}

	//@JsonIgnore
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticleinventaires(List<Article> articles) {
		this.articles = articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
