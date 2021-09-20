package com.inventry.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
