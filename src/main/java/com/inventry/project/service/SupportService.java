package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;


import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.support.repo.SupportacquistionRepository;

@Service
@Transactional

public class SupportService {
	
	@Autowired
	SupportacquistionRepository supportacquistionRepository ;
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	Supportacquistion supportacquisition;
	
	@Qualifier("db2TransactionMgr")
	public List<Supportacquistion> findsupports() {
		System.out.println(this.supportacquistionRepository2.findAll());
		return this.supportacquistionRepository2.findAll();
	}
	
	public List<Supportacquistion> findsupportbysite(Long codesite){
		return this.supportacquistionRepository2.getsupportsbysite(codesite);
	}
	
	public Supportacquistion findsupportbyid(String reference){
		return this.supportacquistionRepository2.findByReference(reference);
	}

}
