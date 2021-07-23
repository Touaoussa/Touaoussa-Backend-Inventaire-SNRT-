package com.inventry.project.model;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Utilisateur implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricule;
	private String identifiant;
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
	
	
	
	
	public Utilisateur(Long matricule, String nom, String prenom, Long tele, String mdps, String identifiant) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
		this.identifiant = identifiant;
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
	

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.mdps;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.identifiant;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
