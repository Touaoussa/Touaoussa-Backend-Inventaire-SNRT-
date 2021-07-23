package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Site;
import com.inventry.project.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

	Utilisateur findByIdentifiant(String identifiant);
}
