package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.DetailssiteRepository;
import com.inventry.project.model.BonLivraison;
import com.inventry.project.model.Detailssite;

@Service
@Transactional
public class DetailsSiteService {

	@Autowired
	DetailssiteRepository detailssiteeepository ;
	
	public List<Detailssite> getalldetailssites(){
		return this.detailssiteeepository.findAll();
	}
	
} 
  