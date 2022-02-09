package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.CommanditaireRepository;
import com.inventry.project.model.Commanditaire;

@Service
@Transactional
public class CommanditaireService  {
	
	@Autowired
	CommanditaireRepository commanditairerepository;
	
	public List<Commanditaire> findallCommanditaires(){
		return this.commanditairerepository.findAll();
	}

}
