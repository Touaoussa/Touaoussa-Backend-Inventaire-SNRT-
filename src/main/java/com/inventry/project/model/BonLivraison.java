package com.inventry.project.model;

import javax.persistence.*;

@Entity
public class BonLivraison {
	@Id
	private Long reference;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ordre;
	private String datebl;
	private String fournisseur;
	private String utilisateur;
}
