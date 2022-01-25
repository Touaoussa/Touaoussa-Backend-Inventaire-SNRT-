package com.inventry.project.DTO;

import java.util.HashSet;
import java.util.Set;

import com.inventry.project.model.Role;

public class UtilisateurDto {
	private Long matricule;
	private String identifiant;
	private String nom;
	private String prenom;
	private Long tele;
	private String mdps;
	private Set<Role> roles = new HashSet<>();
	
	public UtilisateurDto() {
		super();
	}

	public UtilisateurDto(Long matricule, String identifiant, String nom, String prenom, Long tele, String mdps) {
		super();
		this.matricule = matricule;
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
	}

	
	public UtilisateurDto(Long matricule, String identifiant, String nom, String prenom, Long tele, String mdps,
			Set<Role> roles) {
		super();
		this.matricule = matricule;
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
		this.roles = roles;
	}

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getTele() {
		return tele;
	}

	public void setTele(Long tele) {
		this.tele = tele;
	}

	public String getMdps() {
		return mdps;
	}

	public void setMdps(String mdps) {
		this.mdps = mdps;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
