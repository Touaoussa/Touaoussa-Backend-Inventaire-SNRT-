package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventry.project.model.Site;
import com.inventry.project.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

	Utilisateur findByIdentifiant(String identifiant);
	 

	@Query(value="select * from utilisateur u ,roles r ,user_roles ur\r\n"
			+ "where u.matricule=ur.matricule\r\n"
			+ "and ur.role_id = r.id\r\n"
			+ "and r.name='AGENT_INVENTAIRE'",nativeQuery = true )
	List<Utilisateur> getAgents();
}
