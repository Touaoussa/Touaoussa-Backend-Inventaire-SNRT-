package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.SiteRepository;
import com.inventry.project.model.Site;
import com.inventry.project.support.repo.SupportacquistionRepository;

@Service
@Transactional
public class SiteService {

	@Autowired
	SiteRepository siterepository;
	
	public List<Site> findallsites(){
		return this.siterepository.findAll();
	}
	
	public Site addsite(Site site )
	{
		return this.siterepository.save(site);
	}
}
