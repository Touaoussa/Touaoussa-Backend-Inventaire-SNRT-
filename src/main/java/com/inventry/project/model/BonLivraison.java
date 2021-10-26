package com.inventry.project.model;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class BonLivraison {
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
	private String numbl;
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer ordre;
	private String datebl;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="support_id", nullable=false)
	
	private Supportacquistion support;
	
	public BonLivraison() {
		
	}

	public BonLivraison(String numbl, Integer ordre, String datebl, Supportacquistion support) {
		super();
		this.numbl = numbl;
		this.ordre = ordre;
		this.datebl = datebl;
		this.support = support;
	}
	
	
	public BonLivraison(String numbl, Integer ordre, String datebl) {
		super();
		this.numbl = numbl;
		this.ordre = ordre;
		this.datebl = datebl;
	}

	public String getNumbl() {
		return numbl;
	}

	public void setNumBl(String numbl) {
		this.numbl = numbl;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public String getDatebl() {
		return datebl;
	}

	public void setDatebl(String datebl) {
		this.datebl = datebl;
	}

	@JsonIgnore
	public Supportacquistion getSupport() {
		return support;
	}

	@JsonProperty
	public void setSupport(Supportacquistion support) {
		this.support = support;
	}
	
	
	
	
	
}
