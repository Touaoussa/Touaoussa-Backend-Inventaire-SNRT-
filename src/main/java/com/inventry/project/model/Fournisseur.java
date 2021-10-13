package com.inventry.project.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idfournisseur ;
	private String nomfournisseur;
	
	@ManyToMany(mappedBy="fournisseurs",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Supportacquistion> supports;
	
	
	public Fournisseur() {
		
	}

	public Fournisseur(Long idfournisseur, String nomfournisseur, List<Supportacquistion> supports) {
		super();
		this.idfournisseur = idfournisseur;
		this.nomfournisseur = nomfournisseur;
		this.supports = supports;
	}

	public Long getIdfournisseur() {
		return idfournisseur;
	}

	public void setIdfournisseur(Long idfournisseur) {
		this.idfournisseur = idfournisseur;
	}

	public String getNomfournisseur() {
		return nomfournisseur;
	}

	public void setNomfournisseur(String nomfournisseur) {
		this.nomfournisseur = nomfournisseur;
	}

	public List<Supportacquistion> getSupports() {
		return supports;
	}

	public void setSupports(List<Supportacquistion> supports) {
		this.supports = supports;
	}
	
	
}
