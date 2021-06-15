package com.inventry.project.model;


import javax.persistence.*;

@Entity
public class Article {
	public Article(Long numarticle, String nomarticle, String description, int quantite, double prixunitaire,
			double prixtotal, Supportacquistion support) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.support = support;
	}
	@Id
	Long numarticle;
	String nomarticle;
	String description;
	int quantite;
	double prixunitaire;
	double prixtotal;
	//Long support_id;
	@ManyToOne
	@JoinColumn(name="support_id", nullable=false)
	private Supportacquistion support;
	
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
	public Article(Long numarticle, String nomarticle, String description, int quantite, double prixunitaire,
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
