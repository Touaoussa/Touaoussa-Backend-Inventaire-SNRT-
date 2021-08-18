package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.inventry.project.datasource2.repo.RegionRepository;
import com.inventry.project.model.*;

@Service
@Transactional
public class RegionService {

	@Autowired
	RegionRepository regionrepository;
	
	public List<Region> findallregions(){
		return this.regionrepository.findAll();
	}
}
