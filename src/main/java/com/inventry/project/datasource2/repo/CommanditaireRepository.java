package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.BonLivraison;
import com.inventry.project.model.Commanditaire;

public interface CommanditaireRepository extends JpaRepository<Commanditaire,Long> {

}
