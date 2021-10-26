package com.inventry.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.model.BonLivraison;
import com.inventry.project.model.Livraison;
import com.inventry.project.service.BonLivraisonService;
import com.inventry.project.service.LivraisonService;

@CrossOrigin
@RestController
@RequestMapping("/bonlivraisons")
@EnableTransactionManagement
public class BonLivraisonController {

	@Autowired
	BonLivraisonService bonlivraisonservice;
	
	 @PostMapping(path = "/setbonlivraison") 
	    public BonLivraison AddBonLivraison(@RequestBody BonLivraison bonlivraison) throws Exception{	
		return this.bonlivraisonservice.addBonLivraison(bonlivraison);
		}
}
