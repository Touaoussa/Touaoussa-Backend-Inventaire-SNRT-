package com.inventry.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.model.Livraison;
import com.inventry.project.model.Site;
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
	 
	 /*@PostMapping(path = "/setlivraison") 
	    public Reception AddSite(@RequestBody Reception reception) throws Exception{	
		return this.livraisonservice.addLivraison(reception);
		}*/

}
