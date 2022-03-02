package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.DTO.BonLivraisonDto;
import com.inventry.project.model.BonLivraison;
import com.inventry.project.model.Livraison;
import com.inventry.project.service.BonLivraisonService;
import com.inventry.project.service.LivraisonService;

//@CrossOrigin
@RestController
@RequestMapping("/bonlivraisons")
@EnableTransactionManagement
public class BonLivraisonController {

	@Autowired
	BonLivraisonService bonlivraisonservice;
	
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	 @PostMapping(path = "/setbonlivraison") 
	    public BonLivraison AddBonLivraison(@RequestBody BonLivraisonDto bonlivraisondto) throws Exception{	
		 BonLivraison bonlivraison= new BonLivraison();
		 bonlivraison.setNumBl(bonlivraisondto.getNumbl());
		 bonlivraison.setDatebl(bonlivraisondto.getDatebl());
		 bonlivraison.setSupport(bonlivraisondto.getSupport());
		 
		return this.bonlivraisonservice.addBonLivraison(bonlivraison);
		}
	 
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	 @GetMapping(path="/getallbonlivraison")
	 public List<BonLivraison> GetAllBonLivraisons() throws Exception{
		 return this.bonlivraisonservice.getallbonlivraison();
	 }
}
