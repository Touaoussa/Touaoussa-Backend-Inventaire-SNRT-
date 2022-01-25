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

import com.inventry.project.DTO.UtilisateurDto;
import com.inventry.project.datasource2.repo.IUtilisateur;
import com.inventry.project.datasource2.repo.UtilisateurRepository;
import com.inventry.project.model.Site;
import com.inventry.project.model.Utilisateur;
import com.inventry.project.service.MyUserDetailsService;

//@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
@EnableTransactionManagement
public class UtilisateurController {

	@Autowired
	MyUserDetailsService utilisateurservice;
	
	 @GetMapping("/getagents") 
	    public List<IUtilisateur> GetAgents() throws Exception{	
		 return this.utilisateurservice.FindAllAgents();
		}
	 
	 @PostMapping("/AddUtilisateur")
	 	public Utilisateur PutUser(@RequestBody UtilisateurDto utilisateurdto) throws Exception {
		Utilisateur utilisateur = new Utilisateur() ;
		utilisateur.setMatricule(utilisateurdto.getMatricule());
		utilisateur.setIdentifiant(utilisateurdto.getIdentifiant());
		utilisateur.setMdps(utilisateurdto.getMdps());
		utilisateur.setNom(utilisateurdto.getNom());
		utilisateur.setPrenom(utilisateurdto.getPrenom());
		utilisateur.setTele(utilisateurdto.getTele());
		utilisateur.setRoles(utilisateurdto.getRoles());
		 return this.utilisateurservice.Adduser(utilisateur);
	 }
	 
}
