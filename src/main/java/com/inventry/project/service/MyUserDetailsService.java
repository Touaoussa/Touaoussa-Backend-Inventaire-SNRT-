package com.inventry.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.IUtilisateur;
import com.inventry.project.datasource2.repo.TokenBlackListRepository;
import com.inventry.project.datasource2.repo.UtilisateurRepository;
import com.inventry.project.model.TokenBlackList;
import com.inventry.project.model.Utilisateur;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UtilisateurRepository utilisateurrepo;
	
	@Autowired
	TokenBlackListRepository tokenblacklistrepository;
	
	public static final int MAX_FAILED_ATTEMPTS = 3;
    
    private static final long LOCK_TIME_DURATION = 60 * 60 * 1000; // 1 hours
	
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
	
	
	
    public boolean isAccountNonLocked(Utilisateur utilisateur)throws UsernameNotFoundException {
        return utilisateur.isAccountNonLocked();
    }
	
	
	private static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public List<IUtilisateur> FindAllAgents(){
		return this.utilisateurrepo.getAgents();
	}
	
	public Utilisateur Adduser(Utilisateur utilisateur) {
		 utilisateur.setMdps(passwordEncoder().encode(utilisateur.getMdps()));
		return this.utilisateurrepo.save(utilisateur);
	}
	
	public Boolean FindToken(String token) {
		return this.tokenblacklistrepository.existsByToken(token);
	}

	public TokenBlackList AddTokenToBlackList(TokenBlackList token) {
		return this.tokenblacklistrepository.save(token);
	}
	
	
	
	public void increaseFailedAttempts(Utilisateur utilisateur) {
        int newFailAttempts = utilisateur.getFailedattempt() + 1;
        this.utilisateurrepo.updateFailedAttempts(newFailAttempts, utilisateur.getIdentifiant());
    }
     
    public void resetFailedAttempts(String identifiant) {
    	 this.utilisateurrepo.updateFailedAttempts(0, identifiant);
    }
     
    public void lock(Utilisateur user) {
        user.setAccountnonlocked(false);
        user.setLockTime(new Date());
         
        this.utilisateurrepo.save(user);
    }
     
    public boolean unlockWhenTimeExpired(Utilisateur user) {
        long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
         
        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
            user.setAccountnonlocked(true);
            user.setLockTime(null);
            user.setFailedattempt(0);
             
this.utilisateurrepo.save(user);
             
            return true;
        }
         
        return false;
    }
    
    public long GetTimeLeftForUnlock(Utilisateur user) {
    	 long lockTimeInMillis = user.getLockTime().getTime();
         long currentTimeInMillis = System.currentTimeMillis();
         return ((LOCK_TIME_DURATION+lockTimeInMillis)-currentTimeInMillis) /1000/60;
    }
}
