 package com.inventry.project.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Supportacquistion implements Serializable {
	
	@Id
	private Long reference;
	private String type;
	private String path;
		
	@OneToMany(mappedBy="support", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Article> articles;
	
	@OneToMany(mappedBy="support")
	private List<BonLivraison> bonlivraisons;
	
	@OneToMany(mappedBy="supportacqisition" )
	private List<Reception> receptions;

	@ManyToMany
	private List<Site> sites;
	

	@ManyToOne
	@JoinColumn(name="direction_id", nullable=false)
	@JsonIgnore
	private Direction direction;
	
	@ManyToOne
	@JoinColumn(name="fournisseur_id", nullable=false)
	@JsonIgnore
	private Fournisseur fournisseur;

	public Supportacquistion() {
		super();
		this.sites= new ArrayList<Site>();
		this.receptions= new ArrayList<Reception>();
	}
	

	


	public Supportacquistion(Long reference, String type, String path, List<Article> articles, List<Site> sites,
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




	public Supportacquistion(Long reference, String type, String path, List<Article> articles, List<Site> sites,
			List<Reception> receptions) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.sites = sites;
		this.receptions = receptions;
	}

	public Supportacquistion(Long reference ,List<Reception> receptions) {
		super();
		this.reference = reference;
	
		this.receptions = receptions;
	}





	public Supportacquistion(Long reference, String type, String path, List<Article> articles, List<Site> sites) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.sites = sites;
	}



	



	public Supportacquistion(Long reference, String type, String path, List<Article> articles) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
	}



	public Supportacquistion(Long reference) {
		super();
		this.reference = reference;
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

	public Supportacquistion(Long reference, String type) {
		this.reference = reference;
		this.type = type;
	}


	public Long getReference() {
		return reference;
	}


	public void setReference(Long reference) {
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
		
		
		
		

}
