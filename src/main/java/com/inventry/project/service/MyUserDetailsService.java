package com.inventry.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.UtilisateurRepository;
import com.inventry.project.model.Utilisateur;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UtilisateurRepository utilisateurrepo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {
		//Utilisateur utilisateur = utilisateurrepo.findByIdentifiant(identifiant);
		//return new User("snrt","snrt1234",new ArrayList<>());    
		
		Utilisateur utilisateur = utilisateurrepo.findByIdentifiant(identifiant);
		if(utilisateur == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return utilisateur;
	
	} 

}
