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

import com.inventry.project.DTO.PvreceptionDto;
import com.inventry.project.datasource2.repo.IAgents;
import com.inventry.project.datasource2.repo.IHistoriquepv;
import com.inventry.project.datasource2.repo.IUtilisateur;
import com.inventry.project.model.Pvreception;
import com.inventry.project.model.Site;
import com.inventry.project.service.PvService;

//@CrossOrigin
@RestController
@RequestMapping("/pv")
@EnableTransactionManagement
public class PvController {

	@Autowired
	PvService pvservice; 
	
	@GetMapping(path ="/getlastnumpv")
	public Long getlastnumpv(){
		return this.pvservice.getlastnumpv();
	}
	
	@GetMapping(path ="/getallpvs")
	public List<Pvreception> findallpvs(){
		return this.pvservice.getallpv();
	}
	
	 @GetMapping(path = "/getagents") 
	 public List<IAgents> getagents() throws Exception{ 
		 return this.pvservice.getagents();
	 }
	
	@PostMapping(path = "/setpv") 
	    public Pvreception AddPv(@RequestBody PvreceptionDto pvreceptionDto) throws Exception{	
		Pvreception	pvreception = new Pvreception();
		pvreception.setNumpv(pvreceptionDto.getNumpv());
		pvreception.setDate_pv(pvreceptionDto.getDate_pv());
		pvreception.setSupport(pvreceptionDto.getSupport());
		pvreception.setSite(pvreceptionDto.getSite());
		pvreception.setBonlivraison(pvreceptionDto.getBonlivraison());
		pvreception.setAgents(pvreceptionDto.getAgents());
		pvreception.setUtilisateur(pvreceptionDto.getUtilisateur());
		pvreception.setArticles(pvreceptionDto.getArticles());
		pvreception.setPrix_ht(pvreceptionDto.getPrix_ht());
		return this.pvservice.addpv(pvreception);
		}
	 
	 
	 @PostMapping(path = "/getallpv") 
	 public List<Pvreception> gethistoriquepv() throws Exception{
		 return this.pvservice.gethistoriquepv();
	 }

	
}
