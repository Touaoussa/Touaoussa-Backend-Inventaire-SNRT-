package com.inventry.project.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy = false)
public class Article implements Serializable {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	
	//Long support_id;
	@ManyToOne
	@JoinColumn(name="support_id", nullable=false)
	private Supportacquistion support;
		
	@OneToMany(mappedBy = "article")
	@JsonIgnore
	List<Livraison> livraisons;
	
	@ManyToMany
	private List<Pvreception> pvs;
	
	@OneToMany(mappedBy = "article",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	List<DeatilsArticle> detailsarticle ;

	public Long getIdarticle() {
		return idarticle;
	}


	public void setIdarticle(Long idarticle) {
		this.idarticle = idarticle;
	}
	
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

	@JsonIgnore
	public Supportacquistion getSupport() {
		return support;
	}
	@JsonProperty
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

	
	/******************************** new attributes ********************************/

	
	
	


	public Article(Long numarticle, String nomarticle, String description, int quantite, float prixunitaire,
			float prixtotal, String codebare, String complement_intitule, String rI, String caractéristiques,
			String marque, String type, String nsr, String observation, Double lot, Supportacquistion support,
			List<Livraison> livraisons) {
		super();
		this.numarticle = numarticle;
		this.nomarticle = nomarticle;
		this.description = description;
		this.quantite = quantite;
		this.prixunitaire = prixunitaire;
		this.prixtotal = prixtotal;
		this.codebare = codebare;
		this.complement_intitule = complement_intitule;
		this.RI = rI;
		this.caracteristiques = caractéristiques;
		this.marque = marque;
		this.type = type;
		this.nsr = nsr;
		this.observation = observation;
		this.lot = lot;
		this.support = support;
		this.livraisons = livraisons;
	}

	public Article(Long idarticle, Long numarticle, String nomarticle, String description, int quantite,
			float prixunitaire, float prixtotal, String codebare, String complement_intitule, String rI,
			String caracteristiques, String marque, String type, String nsr, String observation, Double lot,
			Boolean immobilisation, Supportacquistion support, List<Livraison> livraisons, List<Pvreception> pvs,
			List<DeatilsArticle> detailsarticle) {
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
		this.support = support;
		this.livraisons = livraisons;
		this.pvs = pvs;
		this.detailsarticle = detailsarticle;
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


	public void setCaracteristiques(String  caracteristiques) {
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

	@JsonIgnore
	public List<Pvreception> getPv() {
		return pvs;
	}

	@JsonProperty
	public void setPv(List<Pvreception> pvs) {
		this.pvs = pvs;
	}


	public List<DeatilsArticle> getDetailsarticle() {
		return detailsarticle;
	}


	public void setDetailsarticle(List<DeatilsArticle> detailsarticle) {
		this.detailsarticle = detailsarticle;
	}
	
	
	
	

}
