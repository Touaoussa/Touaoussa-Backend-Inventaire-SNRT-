package com.inventry.project.usecase;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.inventry.project.model.Direction;
import com.inventry.project.model.DirectionRepository;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.model.SupportacquistionRepository;

@Service
public class InitServiceImp implements InitService {

	@Autowired
	private DirectionRepository directionrepository;
	
	@Autowired
	private SupportacquistionRepository supportacquisitionrepository;
	
	public InitServiceImp() {
		
	}

	@Override
	public void InitDirection() {
		
		Direction direction1=new Direction("direction des systèmes d'information",40);
		Direction direction2=new Direction("direction du support technique",50);
		Supportacquistion supportacquistion = new Supportacquistion("Marché");
		directionrepository.save(direction1);
		directionrepository.save(direction2);
		supportacquisitionrepository.save(supportacquistion);
	}

	@Override
	public void InitSupportacuisition() {
		// TODO Auto-generated method stub
		
	}
}
