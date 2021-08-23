package com.inventry.project.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Livraison implements Serializable{
	
	 @EmbeddedId
	 LvraisonKey id = new LvraisonKey();
	 
	 @ManyToOne
	 @MapsId("receptionId")
	 @JoinColumn(name = "reception_id")
	
	 Reception reception;
	 
	 @ManyToOne
	 @MapsId("articleId")
	 @JoinColumn(name = "article_id")
	 
	 Article article;
	
	 int quantite;

	 public Livraison() {
		 
	 }
	 
	public Livraison(LvraisonKey id, Reception reception, Article article, int quantite) {
		super();
		this.id = id;
		this.reception = reception;
		this.article = article;
		this.quantite = quantite;
	}
	
	public Livraison( Reception reception, Article article, int quantite) {
		super();
		this.reception = reception;
		this.article = article;
		this.quantite = quantite;
	}
	
	

	public LvraisonKey getId() {
		return id;
	}

	public void setId(LvraisonKey id) {
		this.id = id;
	}

	@JsonIgnore
	public Reception getReception() {
		return reception;
	}

	@JsonProperty
	public void setReception(Reception reception) {
		this.reception = reception;
	}
	@JsonIgnore
	public Article getArticle() {
		return article;
	}
	@JsonProperty
	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	 
	 
}
