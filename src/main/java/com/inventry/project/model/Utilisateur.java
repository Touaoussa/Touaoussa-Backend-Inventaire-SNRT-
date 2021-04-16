package com.inventry.project.model;
import javax.persistence.*;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricule;
	private String nom;
	private String prenom;
	private Long tele;
	private String mdps;
	
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(Long matricule, String nom, String prenom, Long tele, String mdps) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
	}
	
	public Long getMatricule() {
		return matricule;
	}
	public void setMatricule(Long matricule) {
		this.matricule = matricule;
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
	
	
}
