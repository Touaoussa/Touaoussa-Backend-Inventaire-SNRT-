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
	//@JsonIgnore
	private List<Article> articles;

	@ManyToMany
	//@JsonIgnore
	private List<Site> sites;
	

	public Supportacquistion() {
		super();
		this.sites= new ArrayList<Site>();
	}



	public Supportacquistion(Long reference, String type, String path, List<Article> articles, List<Site> sites) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.articles = articles;
		this.sites = sites;
	}



	public List<Site> getSites() {
		return sites;
	}



	public void setSites(List<Site> sites) {
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

}
