package com.inventry.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.model.Direction;
import com.inventry.project.model.DirectionRepository;

@CrossOrigin
@RestController
@RequestMapping("/microservice1")
public class MicroService1 {
	
	@Autowired
	DirectionRepository directionrepository ;
	
	@GetMapping("/")
	public void getAllDirections() {
		
	}
	
	@GetMapping("/{intitule}")
	public int Recupérer_nombre_personnel(@PathVariable String intitule){
		Direction direction=directionrepository.findByIntitule(intitule);
		return direction.getNombrepersonnel();
	}
}
