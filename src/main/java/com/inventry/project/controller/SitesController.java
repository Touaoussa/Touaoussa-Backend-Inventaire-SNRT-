package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	 @GetMapping("/getsites") 
	    public List<Site> GetAllSites() throws Exception{	
		 return this.siteservice.findallsites();
		}
	 @PostMapping(path = "/setsite") 
	    public Site AddSite(@RequestBody Site site) throws Exception{	
		return this.siteservice.addsite(site);
		}
}
