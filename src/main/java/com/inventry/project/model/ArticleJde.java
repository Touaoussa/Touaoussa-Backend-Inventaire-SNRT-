package com.inventry.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ArticleJde {
	@Id
	Long numarticle;
	String nomarticle;
	String description;
	int quantite;
	double prixunitaire;
	double prixtotal;
	Long support_id;

	public Long getSupport_id() {
		return support_id;
	}
	public void setSupport_id(Long support_id) {
		this.support_id = support_id;
	}
	
	public ArticleJde() {
		
	}
	public ArticleJde(Long numarticle, String nomarticle, String description, int quantite, double prixunitaire,
			double prixtotal) {
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
	public void setPrixunitaire(double prixunitaire) {
		this.prixunitaire = prixunitaire;
	}
	public double getPrixtotal() {
		return prixtotal;
	}
	public void setPrixtotal(double prixtotal) {
		this.prixtotal = prixtotal;
	}
	
}
