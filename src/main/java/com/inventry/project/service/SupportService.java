package com.inventry.project.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.support.repo.SupportacquistionRepository;

@Service
@Transactional("db2TransactionMgr")
public class SupportService {
	
	@Autowired
	SupportacquistionRepository supportacquistionRepository ;
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	
	public List<Supportacquistion> findsupports() {
		return this.supportacquistionRepository2.findAll();
	}

}
