package com.inventry.project.usecase;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.inventry.project.model.Direction;
import com.inventry.project.model.DirectionRepository;

@Service
public class InitServiceImp implements InitService {

	@Autowired
	private DirectionRepository directionrepository;
	
	
	public InitServiceImp() {
		
	}

	@Override
	public void InitDirection() {
		
		Direction direction=new Direction();
		directionrepository.save(direction);
	}

	@Override
	public void InitSupportacuisition() {
		// TODO Auto-generated method stub
		
	}
}
