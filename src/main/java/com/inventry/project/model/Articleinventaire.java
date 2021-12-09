package com.inventry.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Articleinventaire implements Serializable{

	@Id
	Long idarticle;
	Long numarticle;
	String nomarticle;
	String description;
	int quantite;
	float prixunitaire;
	float prixtotal;
	/*****new attributes********/
	@Column(unique=true)
	String codebare;
	String complement_intitule;
	String RI ;
	String caracteristiques;
	String marque;
	String type;
	@Column(unique=true)
	String nsr;
	String observation;
	Double lot;
	Boolean immobilisation;
	
	@ManyToOne
	@JoinColumn(name="pv_id", nullable=false)
	private Pvreception pv;

	
	
	
	
	public Articleinventaire() {
		super();
	}





	public Articleinventaire(Long idarticle, Long numarticle, String nomarticle, String description, int quantite,
			float prixunitaire, float prixtotal, String codebare, String complement_intitule, String rI,
			String caracteristiques, String marque, String type, String nsr, String observation, Double lot,
			Boolean immobilisation, Pvreception pv) {
		super();
		this.idarticle = idarticle;
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.codebare = codebare;
		this.complement_intitule = complement_intitule;
		RI = rI;
		this.caracteristiques = caracteristiques;
		this.marque = marque;
		this.type = type;
		this.nsr = nsr;
		this.observation = observation;
		this.lot = lot;
		this.immobilisation = immobilisation;
		this.pv = pv;
	}





	public Long getIdarticle() {
		return idarticle;
	}





	public void setIdarticle(Long idarticle) {
		this.idarticle = idarticle;
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





	public String getCodebare() {
		return codebare;
	}





	public void setCodebare(String codebare) {
		this.codebare = codebare;
	}





	public String getComplement_intitule() {
		return complement_intitule;
	}





	public void setComplement_intitule(String complement_intitule) {
		this.complement_intitule = complement_intitule;
	}





	public String getRI() {
		return RI;
	}





	public void setRI(String rI) {
		RI = rI;
	}





	public String getCaracteristiques() {
		return caracteristiques;
	}





	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}





	public String getMarque() {
		return marque;
	}





	public void setMarque(String marque) {
		this.marque = marque;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	public String getNsr() {
		return nsr;
	}





	public void setNsr(String nsr) {
		this.nsr = nsr;
	}





	public String getObservation() {
		return observation;
	}





	public void setObservation(String observation) {
		this.observation = observation;
	}





	public Double getLot() {
		return lot;
	}





	public void setLot(Double lot) {
		this.lot = lot;
	}





	public Boolean getImmobilisation() {
		return immobilisation;
	}





	public void setImmobilisation(Boolean immobilisation) {
		this.immobilisation = immobilisation;
	}





	public Pvreception getPv() {
		return pv;
	}





	public void setPv(Pvreception pv) {
		this.pv = pv;
	}
	
	
	
	
	
	
	
}
