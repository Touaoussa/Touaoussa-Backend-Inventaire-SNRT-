package com.inventry.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Region {

	@Id 
	private Long id_region;
	private String Intitule;
	
	/*@OneToMany(mappedBy="region", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Site> sites;*/
}
