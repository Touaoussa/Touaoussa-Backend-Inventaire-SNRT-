package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.model.BonLivraison;
import com.inventry.project.model.Commanditaire;
import com.inventry.project.service.CommanditaireService;

@RestController
@RequestMapping("/commanditaire")
public class CommanditaireController {
	
	@Autowired
	CommanditaireService commanditaireservice;
	
	 @GetMapping(path="/getallcommanditaires")
	 public List<Commanditaire> GetAllCommanditaires() throws Exception{
		 return this.commanditaireservice.findallCommanditaires();
	 }

}
