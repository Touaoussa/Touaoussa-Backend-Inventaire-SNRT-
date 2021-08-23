package com.inventry.project.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy = false)
public class Article implements Serializable {
	 
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	Long numarticle;
	String nomarticle;
	String description;
	int quantite;
	float prixunitaire;
	float prixtotal;
	//Long support_id;
	@ManyToOne
	@JoinColumn(name="support_id", nullable=false)
	@JsonIgnore
	private Supportacquistion support;
	
	@OneToMany(mappedBy = "article")
	List<Livraison> livraisons;
	
	
	public List<Livraison> getLivraisons() {
		return livraisons;
	}


	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}


	public Article(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal, Supportacquistion support) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.support = support;
	}
	
	
	public Article(Long numarticle) {
		super();
		this.numarticle = numarticle;
	}


	public Supportacquistion getSupport() {
		return support;
	}
	public void setSupport(Supportacquistion support) {
		this.support = support;
	}
	/*public Long getSupport_id() {
		return support_id;
	}
	public void setSupport_id(Long support_id) {
		this.support_id = support_id;
	}*/
	public Article() {
		
	}
	public Article(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
	}
	
	public Long getNumarticle() {
		return numarticle;
	}
	public void setNumarticle(Long numarticle) {
		this.numarticle = numarticle;
	}
	public String getNomarticle() {
		return nomarticle;
	}
	public void setNomarticle(String nomarticle) {
		this.nomarticle = nomarticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrixunitaire() {
		return prixunitaire;
	}
	public void setPrixunitaire(float prixunitaire) {
		this.prixunitaire = prixunitaire;
	}
	public double getPrixtotal() {
		return prixtotal;
	}
	public void setPrixtotal(float prixtotal) {
		this.prixtotal = prixtotal;
	}
	
	

}
