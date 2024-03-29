package com.inventry.project.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
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
import com.inventry.project.model.AuthenticationResponse;
import com.inventry.project.model.JwtAuthorities;
import com.inventry.project.model.Site;
import com.inventry.project.model.TokenBlackList;
import com.inventry.project.model.Utilisateur;
import com.inventry.project.service.MyUserDetailsService;
import com.inventry.project.util.JwtUtil;

//@CrossOrigin
@RestController
@RequestMapping("/utilisateurs")
@EnableTransactionManagement
public class UtilisateurController {

	@Autowired
	MyUserDetailsService utilisateurservice;
	
	@PreAuthorize("hasRole('ROLE_AGENTINVENTAIRE')")
	 @GetMapping("/getagents") 
	    public List<IUtilisateur> GetAgents() throws Exception{	
		 return this.utilisateurservice.FindAllAgents();
		}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 @PostMapping("/getroles") 
	    public Collection<? extends GrantedAuthority> GetRoles( @RequestBody Utilisateur ut) throws Exception{	
		 return this.utilisateurservice.GetAuthorities(ut.getIdentifiant());
		}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	 
	 @PostMapping("/GetAuthorities")
	 	public Collection<? extends GrantedAuthority> GetAuthorities(@RequestBody JwtAuthorities authenticationeesponse) throws Exception {
		 JwtUtil jwtutil = new JwtUtil();
		 return (Collection<? extends GrantedAuthority>) jwtutil.getAuthoritiesFromToken(authenticationeesponse.getJwt());
	 }
	 
	 @PostMapping("/Logout")
	 	public String  Logout(@RequestBody TokenBlackList token) throws Exception {
		 if(this.utilisateurservice.AddTokenToBlackList(token) !=null)
			 return "Token Expiré ";
		 return "";
	 }
	 
}
