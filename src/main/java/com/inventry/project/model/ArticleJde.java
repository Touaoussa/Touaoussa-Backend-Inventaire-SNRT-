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
	float prixunitaire;
	float prixtotal;
	String support_id;
	long numfournisseur;
	String fournisseur;
	float montant_ht;
	
	public String getSupport_id() {
		return support_id;
	}
	public void setSupport_id(String support_id) {
		this.support_id = support_id;
	}
	
	
	
	public ArticleJde(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal, String support_id, long numfournisseur, String fournisseur, float montant_ht) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.support_id = support_id;
		this.numfournisseur = numfournisseur;
		this.fournisseur = fournisseur;
		this.montant_ht = montant_ht;
	}
	

	public ArticleJde(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal, String support_id, long numfournisseur, String fournisseur) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.support_id = support_id;
		this.numfournisseur = numfournisseur;
		this.fournisseur = fournisseur;
	}
	
	public ArticleJde() {
		
	}
	public ArticleJde(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
	}
	
	
	
	public ArticleJde(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal, String support_id, String fournisseur) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.support_id = support_id;
		this.fournisseur = fournisseur;
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
	public float getPrixunitaire() {
		return prixunitaire;
	}
	public void setPrixunitaire(float prixunitaire) {
		this.prixunitaire = prixunitaire;
	}
	public float getPrixtotal() {
		return prixtotal;
	}
	public void setPrixtotal(float prixtotal) {
		this.prixtotal = prixtotal;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public long getNumfournisseur() {
		return numfournisseur;
	}
	public void setNumfournisseur(long numfournisseur) {
		this.numfournisseur = numfournisseur;
	}
	public float getMontant_ht() {
		return montant_ht;
	}
	public void setMontant_ht(float montant_ht) {
		this.montant_ht = montant_ht;
	}
	
	
}
