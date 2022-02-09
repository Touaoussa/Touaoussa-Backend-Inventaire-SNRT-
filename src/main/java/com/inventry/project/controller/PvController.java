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

import com.inventry.project.DTO.PvreceptionDto;
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
	ArticleService articleservice;
	
	@GetMapping(path ="/getlastnumpv")
	public Long getlastnumpv(){
		return this.pvservice.getlastnumpv();
	}
	
	@GetMapping(path ="/getallpvs")
	public List<Pvreception> findallpvs(){
		return this.pvservice.getallpv();
	}
	
	 @GetMapping(path = "/getagents") 
	 public List<IAgents> getagents() throws Exception{ 
		 return this.pvservice.getagents();
	 }
	
	@PostMapping(path = "/setpv") 
	    public Pvreception AddPv(@RequestBody PvArticle pvarticle) throws Exception{	
		Pvreception	pvreception = new Pvreception();
		System.out.println("hhhhhhhh"+pvarticle.getArticles().get(0).getIdarticle());
		pvreception.setNumpv(pvarticle.getPv().getNumpv());
		pvreception.setDate_pv(pvarticle.getPv().getDate_pv());
		pvreception.setSupport(pvarticle.getPv().getSupport());
		pvreception.setSite(pvarticle.getPv().getSite()); 
		pvreception.setBonlivraison(pvarticle.getPv().getBonlivraison());
		pvreception.setAgents(pvarticle.getPv().getAgents());
		pvreception.setUtilisateur(pvarticle.getPv().getUtilisateur());
		//pvreception.setArticles(pvarticle.getPv().getArticles());
		pvreception.setPrix_ht(pvarticle.getPv().getPrix_ht());
		this.articleservice.updatearticles(pvarticle.getArticles());
		return this.pvservice.addpv(pvreception);
		}
	 
	 
	 @PostMapping(path = "/getallpv") 
	 public List<Pvreception> gethistoriquepv() throws Exception{
		 return this.pvservice.gethistoriquepv();
	 }

	
}
