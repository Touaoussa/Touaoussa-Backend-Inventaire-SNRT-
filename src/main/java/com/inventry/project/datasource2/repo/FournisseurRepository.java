package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Detailssite;
import com.inventry.project.model.Fournisseur;

public interface FournisseurRepository  extends JpaRepository<Fournisseur,Long> {

}
