package com.inventry.project.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.DTO.PvreceptionDto;
import com.inventry.project.Exception.DuplicateCDBException;
import com.inventry.project.datasource2.repo.IAgents;
import com.inventry.project.datasource2.repo.IHistoriquepv;
import com.inventry.project.datasource2.repo.IUtilisateur;
import com.inventry.project.model.Article;
import com.inventry.project.model.PvArticle;
import com.inventry.project.model.Pvreception;
import com.inventry.project.model.Site;
import com.inventry.project.service.ArticleService;
import com.inventry.project.service.PvService;

//@CrossOrigin
@RestController
@RequestMapping("/pv")
@EnableTransactionManagement
public class PvController {

	@Autowired
	PvService pvservice; 
	@Autowired
	ArticleService articleservice;
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	@GetMapping(path ="/getlastnumpv")
	public Long getlastnumpv() throws Exception{
		if (this.pvservice.getlastnumpv()==null) return (long) 0;
		return this.pvservice.getlastnumpv();
	}
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	@GetMapping(path ="/getallpvs")
	public List<Pvreception> findallpvs(){
		return this.pvservice.getallpv();
	}
	
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	 @GetMapping(path = "/getagents") 
	 public List<IAgents> getagents() throws Exception{ 
		 return this.pvservice.getagents();
	 }
	
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	@PostMapping(path = "/setpv")
	@Transactional(rollbackOn = Exception.class)
	    public Pvreception AddPv(@Valid @RequestBody PvreceptionDto pvarticle) throws Exception{	
		Pvreception PV=null;
			Pvreception	pvreception = new Pvreception();
			pvreception.setNumpv(pvarticle.getNumpv());
			pvreception.setDate_pv(pvarticle.getDate_pv());
			pvreception.setSupport(pvarticle.getSupport());
			pvreception.setSite(pvarticle.getSite()); 
			pvreception.setBonlivraison(pvarticle.getBonlivraison());
			pvreception.setAgents(pvarticle.getAgents());
			pvreception.setUtilisateur(pvarticle.getUtilisateur());
			//pvreception.setArticles(pvarticle.getArticles());
			//pvreception.setPrix_ht(pvarticle.getPrix_ht());
			PV = this.pvservice.addpv(pvreception);
			this.articleservice.updatearticles(pvarticle.getArticles());
		return PV;
		}
	 
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	 @PostMapping(path = "/getallpv") 
	 public List<Pvreception> gethistoriquepv() throws Exception{
		 return this.pvservice.gethistoriquepv();
	 }

	
}
