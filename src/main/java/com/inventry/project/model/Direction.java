package com.inventry.project.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Direction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iddirection;	
	private String intitule;
	
	@OneToMany(mappedBy="direction", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Supportacquistion> listsupport  ;

	public Direction() {
		
	}

	public Direction(Long iddirection, String intitule, List<Supportacquistion> listsupport) {
		super();
		this.iddirection = iddirection;
		this.intitule = intitule;
		this.listsupport = listsupport;
	}




	public Long getIddirection() {
		return iddirection;
	}

	public void setIddirection(Long iddirection) {
		this.iddirection = iddirection;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Supportacquistion> getListsupport() {
		return listsupport;
	}

	public void setListsupport(List<Supportacquistion> listsupport) {
		this.listsupport = listsupport;
	}
	
	
	
	

}
