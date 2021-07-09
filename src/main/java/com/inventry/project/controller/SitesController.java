package com.inventry.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.model.Article;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.service.SiteService;

@CrossOrigin
@RestController
@RequestMapping("/sites")
@EnableTransactionManagement
public class SitesController {
	
	@Autowired
	SiteService siteservice;
	
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	
	 @GetMapping("/getsites") 
	    public List<Site> GetAllSites() throws Exception{	
		 return this.siteservice.findallsites();
		}
	 
	 @PostMapping("/getsitessupport") 
	    public Optional<Supportacquistion> GetSitesSupport(@RequestBody Supportacquistion support) throws Exception{	
		 return this.siteservice.findsupportbyrefernce(support.getReference());
		}
	 
	 @PostMapping(path = "/setsite") 
	    public Site AddSite(@RequestBody Site site) throws Exception{	
		return this.siteservice.addsite(site);
		}
	 
	 @PostMapping(path = "/affectersite") 
	    public Supportacquistion AffecterSite(@RequestBody Supportacquistion supportacquisition) throws Exception{			 
		return this.siteservice.affectersite(supportacquisition);
		}
}
