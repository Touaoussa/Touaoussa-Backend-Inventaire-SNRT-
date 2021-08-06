package com.inventry.project.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Reception implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_reception;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date_reception;
	private String type_reception;
	
	@ManyToOne
	@JoinColumn(name="support_id", nullable=false)
	@JsonIgnore
	private Supportacquistion supportacqisition;
	
	
	public Reception() {
		
	}
	
	

	public Reception(Long id_reception, Date date_reception, String type_reception) {
		super();
		this.id_reception = id_reception;
		this.date_reception = date_reception;
		this.type_reception = type_reception;
	}



	public Reception(Long id_reception, Date date_reception, String type_reception,
			Supportacquistion supportacqisition) {
		super();
		this.id_reception = id_reception;
		this.date_reception = date_reception;
		this.type_reception = type_reception;
		this.supportacqisition = supportacqisition;
	}
	
	public Reception( Date date_reception, String type_reception,Supportacquistion supportacqisition) {
	
		this.date_reception = date_reception;
		this.type_reception = type_reception;
		this.supportacqisition = supportacqisition;
	}


	public Long getId_reception() {
		return id_reception;
	}

	public void setId_reception(Long id_reception) {
		this.id_reception = id_reception;
	}

	public Date getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(Date date_reception) {
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
	
		

}
