package com.inventry.project.utilisateur.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{

}
