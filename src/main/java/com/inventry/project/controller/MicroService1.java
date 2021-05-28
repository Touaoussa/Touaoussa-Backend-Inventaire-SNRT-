package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inventry.project.model.*;
import com.inventry.project.support.repo.SupportacquistionRepository;
import com.inventry.project.support2.repo.SupportacquistionRepository2;
import com.inventry.project.configuration.*;
import com.inventry.project.direction.repo.DirectionRepository;
@CrossOrigin
@RestController
@RequestMapping("/microservice1")
@EnableTransactionManagement
public class MicroService1 {
	
	@Autowired
	DirectionRepository directionrepository ;
	
	@Autowired
	SupportacquistionRepository supportacquistionRepository ;
	
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	
	
	/*@GetMapping("/")
	public void getAllDirections() {
		
	}*/
	
	@Transactional
	public Supportacquistion Recupérer_support_acquisition(){
		List<Supportacquistion> listsupportacquistion =  supportacquistionRepository.getsupports();
		return listsupportacquistion.get(0);
	}
	
	
	@GetMapping("/Supportacquistion")
	public Supportacquistion add_support_acquisition(){
		Supportacquistion supportacquisition = this.Recupérer_support_acquisition();
		Supportacquistionlocal supportacquisitionlocal = new Supportacquistionlocal(supportacquisition.getReference(),supportacquisition.getType());
		supportacquistionRepository2.save(supportacquisitionlocal);
		return supportacquisition;		
	}
	
	/*@GetMapping("/{intitule}")
	public Object Recupérer_nombre_personnel(@PathVariable String intitule){
		//Direction direction=directionrepository.findByIntitule(intitule);
		List<Object> listsupportacquistion =  supportacquistionRepository.getsupports();
		return listsupportacquistion.get(0);
	}*/
	
/*	@GetMapping("/{Supportacquistion}")
		public Object Recupérer_support_acquisition(){
		List<Object> listsupportacquistion =  supportacquistionRepository.getsupports();
		//Long nbr = supportacquistionRepository.count();
		return listsupportacquistion.get(0);
	}*/
	
}
