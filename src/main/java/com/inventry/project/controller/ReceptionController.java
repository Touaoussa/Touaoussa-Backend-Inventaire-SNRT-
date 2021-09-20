package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.datasource2.repo.ReceptionRepository;
import com.inventry.project.model.Article;
import com.inventry.project.model.Reception;
import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;
import com.inventry.project.service.ReceptionService;

@CrossOrigin
@RestController
@RequestMapping("/receptions")
@EnableTransactionManagement

public class ReceptionController {

	@Autowired
	ReceptionRepository receptionrepository;
	 
	@Autowired 
	ReceptionService receptionservice;

	 @GetMapping("/getreceptions") 
	    public List<Reception> GetAllReceptions() throws Exception{	
		 return this.receptionservice.findallreceptions();
		}
	 
	 
	 @PostMapping(path = "/addreception") 
	    public Reception AddReception(@RequestBody Reception reception) throws Exception{			 
		return this.receptionservice.addreception(reception);
		}
	 
	/* @PostMapping(path = "/setreception") 
	    public Supportacquistion AffecterReception(@RequestBody Supportacquistion supportacquisition) throws Exception{			 
		return this.receptionservice.affecterReception(supportacquisition);
		}
	 */
	 @PostMapping(path = "/updatereception")  
	    public Reception ModifierReception(@RequestBody Reception reception) throws Exception{			 
		return this.receptionservice.updatereceptions(reception);
		}
	   
	 @PostMapping(path = "/deleteereception") 
	    public void SupprimerReception(@RequestBody Reception reception) throws Exception{			 
		 this.receptionservice.DeleteReception(reception);
		}
	 
	 @PostMapping("/getreceptionsbysupport") 
	    public List<Reception> GetReceptionbySupport(@RequestBody Supportacquistion supportacquisition) throws Exception{	
		 return this.receptionservice.findabySupport(supportacquisition.getReference());
		}
	 
	 
	 /*   public Reception AddReception(@RequestBody Reception reception) throws Exception{	
		return this.receptionservice.addreception(reception);
		}
	 */
	 
}
