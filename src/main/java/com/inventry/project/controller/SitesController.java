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

import com.inventry.project.DTO.SiteDto;
import com.inventry.project.DTO.SupportacquistionDto;
import com.inventry.project.DTO.UtilisateurDto;
import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.model.Article;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.model.Utilisateur;
import com.inventry.project.service.SiteService;
import com.inventry.project.service.SupportService;

//@CrossOrigin
@RestController
@RequestMapping("/sites")
@EnableTransactionManagement
public class SitesController {
	
	@Autowired
	SiteService siteservice;
	
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	
	@Autowired 
	SupportService supportservice;
	
	 @GetMapping("/getsites") 
	    public List<Site> GetAllSites() throws Exception{	
		 return this.siteservice.findallsites();
		}
	 
	 @PostMapping("/getsitessupport") 
	    public Optional<Supportacquistion> GetSitesSupport(@RequestBody SupportacquistionDto supportdto) throws Exception{	
		 return this.siteservice.findsupportbyrefernce(supportdto.getReference());
		}
	 
	 @PostMapping(path = "/setsite") 
	    public Site AddSite(@RequestBody SiteDto sitedto) throws Exception{	
		 Site site=new Site();
		 site.setCodification(sitedto.getCodification());
		 site.setLocalite(sitedto.getLocalite());
		 site.setAdresse(sitedto.getAdresse());
		 site.setIntitule(sitedto.getIntitule());
		 site.setCordonneesgps(sitedto.getCordonneesgps());
		 site.setRegion(sitedto.getRegion());
		 site.setUtilisateur(sitedto.getUtilisateur());
		return this.siteservice.addsite(site);
		}
	 
	 @PostMapping(path = "/affectersite") 
	    public Supportacquistion AffecterSite(@RequestBody SupportacquistionDto supportacquisitionDto) throws Exception{	
		 Supportacquistion supportacquisition= new Supportacquistion();
		 supportacquisition.setReference(supportacquisitionDto.getReference());
		 supportacquisition.setSites(supportacquisitionDto.getSites());
		return this.siteservice.affectersite(supportacquisition);
		}
	 
	 @PostMapping("/getsiteresponsable") 
	    public List<Site> GetSitesResponsable(@RequestBody UtilisateurDto utilisateurdto) throws Exception{
		 return this.siteservice.findsitebyresponsable(utilisateurdto.getMatricule());
		}
	 
	 @PostMapping("/getsitesupport") 
	    public List<Supportacquistion> GetSitesSupports(@RequestBody SiteDto sitedto) throws Exception{
		 return this.supportservice.findsupportbysite(sitedto.getCodification());
		}
}
