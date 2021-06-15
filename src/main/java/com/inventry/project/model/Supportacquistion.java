package com.inventry.project.model;

import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
public class Supportacquistion {
	
	@Id
	private Long reference;
	private String type;
	 @OneToMany(mappedBy="support")
	  private Set<Article> articles;

	public Supportacquistion(Long reference, String type, Set<Article> articles) {
		super();
		this.reference = reference;
		this.type = type;
		this.articles = articles;
	}

	public Supportacquistion(Long reference) {
		super();
		this.reference = reference;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Supportacquistion(Long reference, String type) {
		this.reference = reference;
		this.type = type;
	}

	public Supportacquistion() {
		
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

	

}
