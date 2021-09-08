package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.datasource2.repo.IHistoriqueLivraison;
import com.inventry.project.model.HistoriqueLivraison;
import com.inventry.project.model.Livraison;
import com.inventry.project.model.Reception;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.service.LivraisonService;

@CrossOrigin
@RestController
@RequestMapping("/livraisons")
@EnableTransactionManagement
public class LivraisonController {
	@Autowired
	LivraisonService livraisonservice;
	
	 @PostMapping(path = "/setlivraison") 
	    public Livraison AddLivraison(@RequestBody Livraison livraison) throws Exception{	
		return this.livraisonservice.addLivraison(livraison);
		}
	 
	 @PostMapping(path = "/deletelivraison") 
	    public void RemoveLivraison(@RequestBody Livraison livraison) throws Exception{	
		 this.livraisonservice.deleteLivraison(livraison);
		}
	 
	 @PostMapping(path="/getnumarticles")
	 public List<Long> getAllnumarticles(@RequestBody Livraison livraison) throws Exception{
		return this.livraisonservice.getnumarticles(livraison.getReception().getId_reception());
	 }
	 
	 @PostMapping(path="/gethistoriquelivraison")
	 public List<IHistoriqueLivraison> gethistoriquelivraison(@RequestBody Supportacquistion supportacquistion) throws Exception{
		return this.livraisonservice.gethstoriquelivraison(supportacquistion.getReference());
	 }
	 
	 
	 /*@PostMapping(path = "/setlivraison") 
	    public Reception AddSite(@RequestBody Reception reception) throws Exception{	
		return this.livraisonservice.addLivraison(reception);
		}*/

}
