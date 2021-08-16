package com.inventry.project.service;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.ReceptionRepository;
import com.inventry.project.datasource2.repo.SiteRepository;
import com.inventry.project.datasource2.repo.SupportacquistionRepository2;
import com.inventry.project.model.Reception;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.support.repo.SupportacquistionRepository;

@Service
@Transactional

public class ReceptionService {
	
	
	@Autowired
	ReceptionRepository receptionrepository;
	
	@Autowired
	SupportacquistionRepository2 supportacquistionRepository2 ;
	
	public Reception addreception(Reception reception )
	{
		return this.receptionrepository.save(reception);
	}
	
	/*public Reception affecterReception(Reception reception) {
		return this.receptionrepository.save(reception);
	}*/
	
	
	public Supportacquistion affecterReception(Supportacquistion supportacquistion) {
     
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
		        DateFormat.SHORT,
		        DateFormat.SHORT);
		
		
		Supportacquistion supportacquistion2 =  this.supportacquistionRepository2.findByReference(supportacquistion.getReference());
		System.out.println("****************"+supportacquistion.getReceptions().get(0).getType_reception());
		List<Reception> receptions = supportacquistion.getReceptions();
		
		//this.receptionrepository.deleteBysupportreference(supportacquistion.getReference());
		 
		for(int i=0;i < receptions.size();i++) {
			//receptions.get(i).setDate_reception(shortDateFormat.format(receptions.get(i).getDate_reception()));
			Reception reception = new Reception(receptions.get(i).getDate_reception(), receptions.get(i).getType_reception() , supportacquistion2);		
			this.receptionrepository.save(reception);
		}
		return this.supportacquistionRepository2.save(supportacquistion2);	
	}
	
	
	 
	public List<Reception> findallreceptions(){
		return this.receptionrepository.findAll();
	}
	
	public Reception updatereceptions(Reception reception){
		System.out.println(reception.getId_reception());
		Reception reception2 =  this.receptionrepository.findById(reception.getId_reception()).get();		 
		reception2.setType_reception(reception.getType_reception());
		reception2.setDate_reception(reception.getDate_reception()); 
		return this.receptionrepository.save(reception2); 
	}
	 
	public void DeleteReception(Reception reception) {
		 this.receptionrepository.deleteById(reception.getId_reception());
	}
	public List<Reception> findabySupport(Long ref){
	return this.receptionrepository.findBysupportreference(ref);
	 } 
	
	

}
