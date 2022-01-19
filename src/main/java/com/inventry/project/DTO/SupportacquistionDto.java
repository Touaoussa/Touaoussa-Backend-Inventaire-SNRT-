package com.inventry.project.DTO;

import java.util.List;

import javax.persistence.Id;

import com.inventry.project.model.Direction;
import com.inventry.project.model.Fournisseur;
import com.inventry.project.model.Site;

public class SupportacquistionDto {

	private Long reference;
	private String type;
	private String path;
	private Direction direction;
	private Fournisseur fournisseur;
	private List<Site> sites;
	
	public SupportacquistionDto() {
		super();
	}
	
	
	

	public SupportacquistionDto(Long reference, String type, String path, Direction direction,
			Fournisseur fournisseur) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.direction = direction;
		this.fournisseur = fournisseur;
	}




	public SupportacquistionDto(Long reference, String type, String path, Direction direction, Fournisseur fournisseur,
			List<Site> sites) {
		super();
		this.reference = reference;
		this.type = type;
		this.path = path;
		this.direction = direction;
		this.fournisseur = fournisseur;
		this.sites = sites;
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




	public List<Site> getSites() {
		return sites;
	}




	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	
	
}
