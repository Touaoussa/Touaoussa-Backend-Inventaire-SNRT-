package com.inventry.project.DTO;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventry.project.model.Supportacquistion;

public class BonLivraisonDto {
	private String numbl;
	private Integer ordre;
	private String datebl;
	private Supportacquistion support;
	
	public BonLivraisonDto() {
		super();
	}

	public BonLivraisonDto(String numbl, Integer ordre, String datebl, Supportacquistion support) {
		super();
		this.numbl = numbl;
		this.ordre = ordre;
		this.datebl = datebl;
		this.support = support;
	}

	public String getNumbl() {
		return numbl;
	}

	public void setNumbl(String numbl) {
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

	public Supportacquistion getSupport() {
		return support;
	}

	public void setSupport(Supportacquistion support) {
		this.support = support;
	}
	
	
	
}
