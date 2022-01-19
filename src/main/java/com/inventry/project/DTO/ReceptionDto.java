package com.inventry.project.DTO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;

public class ReceptionDto {

	private Long id_reception;
	private String date_reception;
	private String type_reception;
	private Supportacquistion supportacqisition;
	private Site site;
	
	public ReceptionDto() {
		super();
	}

	public ReceptionDto(Long id_reception, String date_reception, String type_reception,
			Supportacquistion supportacqisition, Site site) {
		super();
		this.id_reception = id_reception;
		this.date_reception = date_reception;
		this.type_reception = type_reception;
		this.supportacqisition = supportacqisition;
		this.site = site;
	}

	public Long getId_reception() {
		return id_reception;
	}

	public void setId_reception(Long id_reception) {
		this.id_reception = id_reception;
	}

	public String getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(String date_reception) {
		this.date_reception = date_reception;
	}

	public String getType_reception() {
		return type_reception;
	}

	public void setType_reception(String type_reception) {
		this.type_reception = type_reception;
	}

	public Supportacquistion getSupportacqisition() {
		return supportacqisition;
	}

	public void setSupportacqisition(Supportacquistion supportacqisition) {
		this.supportacqisition = supportacqisition;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	
	
}
