package com.inventry.project.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BonLivraison {
	@Id
	private Long reference;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ordre;
	private String datebl;
	
	@ManyToOne
	@JoinColumn(name="supportr_id", nullable=false)
	@JsonIgnore
	private Supportacquistion support;

	public BonLivraison(Long reference, Integer ordre, String datebl, Supportacquistion support) {
		super();
		this.reference = reference;
		this.ordre = ordre;
		this.datebl = datebl;
		this.support = support;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
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

	public Supportacquistion getSupport() {
		return support;
	}

	public void setSupport(Supportacquistion support) {
		this.support = support;
	}
	
	
	
	
	
}
