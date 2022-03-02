package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.DTO.ReceptionDto;
import com.inventry.project.DTO.SupportacquistionDto;
import com.inventry.project.datasource2.repo.ReceptionRepository;
import com.inventry.project.model.Article;
import com.inventry.project.model.Reception;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.service.ReceptionService;

//@CrossOrigin
@RestController
@RequestMapping("/receptions")
@EnableTransactionManagement

public class ReceptionController {

	@Autowired
	ReceptionRepository receptionrepository;
	 
	@Autowired 
	ReceptionService receptionservice;

	@PreAuthorize("hasRole('ROLE_RESPONSABLE','ROLE_AGENTINVENTAIRE')")
	 @GetMapping("/getreceptions") 
	    public List<Reception> GetAllReceptions() throws Exception{	
		 return this.receptionservice.findallreceptions();
		}
	 
	 @PreAuthorize("hasRole('ROLE_RESPONSABLE')")
	 @PostMapping(path = "/addreception") 
	    public Reception AddReception(@RequestBody ReceptionDto receptiondto) throws Exception{			
			 Reception reception =new Reception();
			 reception.setId_reception(receptiondto.getId_reception());
			 reception.setDate_reception(receptiondto.getDate_reception());
			 reception.setType_reception(receptiondto.getType_reception());
			 reception.setSupportacqisition(receptiondto.getSupportacqisition());
			 reception.setSite(receptiondto.getSite());
		return this.receptionservice.addreception(reception);
		}
	 
	/* @PostMapping(path = "/setreception") 
	    public Supportacquistion AffecterReception(@RequestBody Supportacquistion supportacquisition) throws Exception{			 
		return this.receptionservice.affecterReception(supportacquisition);
		}
	 */
	 @PreAuthorize("hasRole('ROLE_RESPONSABLE')")
	 @PostMapping(path = "/updatereception")  
	    public Reception ModifierReception(@RequestBody ReceptionDto receptiondto) throws Exception{		
		 Reception reception =new Reception();
		 reception.setId_reception(receptiondto.getId_reception());
		 reception.setDate_reception(receptiondto.getDate_reception());
		 reception.setType_reception(receptiondto.getType_reception());
		 reception.setSupportacqisition(receptiondto.getSupportacqisition());
		 reception.setSite(receptiondto.getSite());
		return this.receptionservice.updatereceptions(reception);
		}
	   
	 @PreAuthorize("hasRole('ROLE_RESPONSABLE')")
	 @PostMapping(path = "/deleteereception") 
	    public void SupprimerReception(@RequestBody ReceptionDto receptiondto) throws Exception{		
		 Reception reception =new Reception();
		 reception.setId_reception(receptiondto.getId_reception());
		 reception.setDate_reception(receptiondto.getDate_reception());
		 reception.setType_reception(receptiondto.getType_reception());
		 reception.setSupportacqisition(receptiondto.getSupportacqisition());
		 reception.setSite(receptiondto.getSite());
		 this.receptionservice.DeleteReception(reception);
		}
	 
	 @PreAuthorize("hasRole('ROLE_RESPONSABLE','ROLE_AGENTINVENTAIRE')")
	 @PostMapping("/getreceptionsbysupport") 
	    public List<Reception> GetReceptionbySupport(@RequestBody SupportacquistionDto supportacquisitiondto) throws Exception{	
		 return this.receptionservice.findabySupport(supportacquisitiondto.getReference());
		}
	 
	 
	 /*   public Reception AddReception(@RequestBody Reception reception) throws Exception{	
		return this.receptionservice.addreception(reception);
		}
	 */
	 
}
