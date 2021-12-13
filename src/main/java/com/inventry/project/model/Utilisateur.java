package com.inventry.project.model;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
	
	@OneToMany(mappedBy="utilisateur", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Site> sites;
	
	//@OneToMany(mappedBy="agent", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Pvreception> pvs;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_roles",
	joinColumns = @JoinColumn(name="matricule"),
	inverseJoinColumns= @JoinColumn(name ="role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	public Utilisateur(Long matricule) {
		super();
		this.matricule = matricule;
	}

	public Utilisateur() {
	}
	
	
	
	
	public Utilisateur(Long matricule, String identifiant, String nom, String prenom, Long tele, String mdps,
			List<Site> sites, List<Pvreception> pvs, Set<Role> roles) {
		super();
		this.matricule = matricule;
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
		this.sites = sites;
		this.pvs = pvs;
		this.roles = roles;
	}

	public Utilisateur(Long matricule, String identifiant, String nom, String prenom, Long tele, String mdps,
			List<Site> sites, List<Pvreception> pvs) {
		super();
		this.matricule = matricule;
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
		this.sites = sites;
		this.pvs = pvs;
	}

	public List<Pvreception> getPvs() {
		return pvs;
	}

	public void setPvs(List<Pvreception> pvs) {
		this.pvs = pvs;
	}

	public Utilisateur(Long matricule, String nom, String prenom, Long tele, String mdps) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
	}
	
	public Utilisateur(Long matricule, String nom, String prenom) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}
	

	public Utilisateur(Long matricule, String identifiant, String nom, String prenom, Long tele, String mdps,
			List<Site> sites) {
		super();
		this.matricule = matricule;
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.mdps = mdps;
		this.sites = sites;
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
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = this.roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()) ) 
				.collect(Collectors.toList() );
		return authorities;
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
	
	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
