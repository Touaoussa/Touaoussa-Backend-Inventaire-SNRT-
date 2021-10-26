package com.inventry.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.BonLivraisonRepository;
import com.inventry.project.model.BonLivraison;

@Service
@Transactional
public class BonLivraisonService {

	@Autowired
	BonLivraisonRepository bonlivraisonrepository;
	
	public BonLivraison addBonLivraison(BonLivraison bonlivraison) {
		return this.bonlivraisonrepository.save(bonlivraison);
	}
}
