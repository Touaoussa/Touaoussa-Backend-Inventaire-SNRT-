package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.model.Detailssite;
import com.inventry.project.model.Site;
import com.inventry.project.service.DetailsSiteService;
import com.inventry.project.service.SiteService;

//@CrossOrigin
@RestController
@RequestMapping("/sites")
@EnableTransactionManagement
public class DetailssiteController {

	@Autowired
	DetailsSiteService detailssiteservice;
	
	 @GetMapping("/getdetailssites") 
	    public List<Detailssite> GetAllSites() throws Exception{	
		 return this.detailssiteservice.getalldetailssites();
		}
}
