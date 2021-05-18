package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.inventry.project.model.*;
@CrossOrigin
@RestController
@RequestMapping("/microservice1")
public class MicroService1 {
	
	@Autowired
	DirectionRepository directionrepository ;
	
	@Autowired
	SupportacquistionRepository supportacquistionRepository ;
	
	/*@GetMapping("/")
	public void getAllDirections() {
		
	}*/
	
	@GetMapping("/Supportacquistion")
	public Supportacquistion Hello(){
		List<Supportacquistion> listsupportacquistion =  supportacquistionRepository.getsupports();
		return listsupportacquistion.get(0);
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
