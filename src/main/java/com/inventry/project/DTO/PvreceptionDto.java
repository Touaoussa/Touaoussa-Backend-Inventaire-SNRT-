package com.inventry.project.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventry.project.model.Article;
import com.inventry.project.model.BonLivraison;
import com.inventry.project.model.Detailssite;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.model.Utilisateur;

public class PvreceptionDto {
	private String numpv;
	@JsonFormat(pattern="dd-MM-yyyy")
	private String date_pv;
	private String utilisateur;
	private Supportacquistion support;
	private Detailssite site;
	private BonLivraison bonlivraison;
	private List<Utilisateur> agents;
	private List<Article> articles;
	private Double prix_ht;
	
	public PvreceptionDto() {
		super();
	}

	public PvreceptionDto(String numpv, String date_pv, String utilisateur, Supportacquistion support, Detailssite site,
			BonLivraison bonlivraison, List<Utilisateur> agents) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.support = support;
		this.site = site;
		this.bonlivraison = bonlivraison;
		this.agents = agents;
	}
	
	

	public PvreceptionDto(String numpv, String date_pv, String utilisateur, Supportacquistion support, Detailssite site,
			BonLivraison bonlivraison, List<Utilisateur> agents, List<Article> articles, Double prix_ht) {
		super();
		this.numpv = numpv;
		this.date_pv = date_pv;
		this.utilisateur = utilisateur;
		this.support = support;
		this.site = site;
		this.bonlivraison = bonlivraison;
		this.agents = agents;
		this.articles = articles;
		this.prix_ht = prix_ht;
	}

	public String getNumpv() {
		return numpv;
	}

	public void setNumpv(String numpv) {
		this.numpv = numpv;
	}

	public String getDate_pv() {
		return date_pv;
	}

	public void setDate_pv(String date_pv) {
		this.date_pv = date_pv;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Supportacquistion getSupport() {
		return support;
	}

	public void setSupport(Supportacquistion support) {
		this.support = support;
	}

	public Detailssite getSite() {
		return site;
	}

	public void setSite(Detailssite site) {
		this.site = site;
	}

	public BonLivraison getBonlivraison() {
		return bonlivraison;
	}

	public void setBonlivraison(BonLivraison bonlivraison) {
		this.bonlivraison = bonlivraison;
	}

	public List<Utilisateur> getAgents() {
		return agents;
	}

	public void setAgents(List<Utilisateur> agents) {
		this.agents = agents;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Double getPrix_ht() {
		return prix_ht;
	}

	public void setPrix_ht(Double prix_ht) {
		this.prix_ht = prix_ht;
	}
	
	
	

}
