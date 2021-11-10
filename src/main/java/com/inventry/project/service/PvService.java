package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.IAgents;
import com.inventry.project.datasource2.repo.IHistoriquepv;
import com.inventry.project.datasource2.repo.IUtilisateur;
import com.inventry.project.datasource2.repo.PvRepository;
import com.inventry.project.model.Pvreception;

@Service
@Transactional
public class PvService {

	@Autowired
	PvRepository pvrepository;
	
	public Pvreception addpv(Pvreception pv) {
		return this.pvrepository.save(pv);
	}
	
	public List<Pvreception> getallpv(){
		return this.pvrepository.findAll();
	}
	public List<IHistoriquepv> gethistoriquepv(){
		return this.pvrepository.gethstoriquepv();
	}
	
	public List<IAgents> getagents(){
		return this.pvrepository.getagents();
	}
}
