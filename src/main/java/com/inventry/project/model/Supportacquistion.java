 package com.inventry.project.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Supportacquistion implements Serializable {
	
	/**
	 * 
	 */

	@Id
	private String reference;
	private String type;
	private String path;
		
	@OneToMany(mappedBy="support", cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
	private List<Article> articles;
	
	@OneToMany(mappedBy="support" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<BonLivraison> bonlivraisons;
	
	
	@OneToMany(mappedBy="supportacqisition" )
	private List<Reception> receptions;

	
	@ManyToMany
	private List<Site> sites;
	
	
	@OneToMany(mappedBy = "support" ,cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
    List<Pvreception> pvs;
	

	@ManyToOne
	@JoinColumn(name="direction_id", nullable=false)
	@JsonIgnore
	private Direction direction;
	
	@ManyToOne
	@JoinColumn(name="fournisseur_id", nullable=false)
	
	private Fournisseur fournisseur;

	public Supportacquistion() {
		super();
		this.sites= new ArrayList<Site>();
		this.receptions= new ArrayList<Reception>();
	}
	
	
	
	

	public Supportacquistion(String reference, String type, String path, List<Article> articles,
			List<BonLivraison> bonlivraisons, List<Reception> receptions, List<Site> sites, List<Pvreception> pvs,
			Direction direction, Fournisseur fournisseur) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.bonlivraisons = bonlivraisons;
		this.receptions = receptions;
		this.sites = sites;
		this.pvs = pvs;
		this.direction = direction;
		this.fournisseur = fournisseur;
	}





	public Supportacquistion(String reference, String type, String path, List<Article> articles,
			List<BonLivraison> bonlivraisons, List<Reception> receptions, List<Site> sites, Direction direction,
			Fournisseur fournisseur) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.bonlivraisons = bonlivraisons;
		this.receptions = receptions;
		this.sites = sites;
		this.direction = direction;
		this.fournisseur = fournisseur;
	}

	public Supportacquistion(String reference) {
		super();
		this.reference = reference;
	}

	public Supportacquistion(String reference, String type, String path, List<Article> articles, List<Site> sites,
			List<Reception> receptions, Direction direction, Fournisseur fournisseur) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.sites = sites;
		this.receptions = receptions;
		this.direction = direction;
		this.fournisseur = fournisseur;
	}


	public Supportacquistion(String reference, String type, String path, List<Article> articles, List<Site> sites,
			List<Reception> receptions) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.sites = sites;
		this.receptions = receptions;
	}

	public Supportacquistion(String reference ,List<Reception> receptions) {
		super();
		this.reference = reference;
		this.receptions = receptions;
	}

	public Supportacquistion(String reference, String type, String path, List<Article> articles, List<Site> sites) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.sites = sites;
	}

	public Supportacquistion(String reference, String type, String path, List<Article> articles) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
	}



public Supportacquistion(String reference, String type) {
		this.reference = reference;
		this.type = type;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}

	
	

	public String getType() {
		return type;
	}


		public void setType(String type) {
			this.type = type;
		}
	
		 public String getPath() {
				return path;
			}

		public void setPath(String path) {
			this.path = path;
		}
		
		
		public List<Site> getSites() {
			return sites;
		}



		public void setSites(List<Site> sites) {
			this.sites = sites;
		}

		public List<Article> getArticles() {
			return articles;
		}

		public void setArticles(List<Article> articles) {
			this.articles = articles;
		}

		public List<Reception> getReceptions() {
			return this.receptions;
		}

		public void setReceptions(List<Reception> receptions) {
			this.receptions = receptions;
		}

		public Direction getDirection() {
			return direction;
		}

		public void setDirection(Direction direction) {
			this.direction = direction;
		}

		public Fournisseur getFournisseur() {
			return fournisseur;
		}

		public void setFournisseur(Fournisseur fournisseur) {
			this.fournisseur = fournisseur;
		}
		
		
		public List<BonLivraison> getBonlivraisons() {
			return bonlivraisons;
		}

		public void setBonlivraisons(List<BonLivraison> bonlivraisons) {
			this.bonlivraisons = bonlivraisons;
		}

		@JsonIgnore
		public List<Pvreception> getPvs() {
			return pvs;
		}
		@JsonProperty
		public void setPvs(List<Pvreception> pvs) {
			this.pvs = pvs;
		}
		
		
		

}
