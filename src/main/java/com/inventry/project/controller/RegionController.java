package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.model.Reception;
import com.inventry.project.model.Region;
import com.inventry.project.service.RegionService;

@CrossOrigin
@RestController
@RequestMapping("/regions")
@EnableTransactionManagement

public class RegionController {

	@Autowired
	RegionService regionservice;
	
	 @GetMapping("/getregions") 
	    public List<Region> GetAllReceptions() throws Exception{	
		 return this.regionservice.findallregions();
		}
}
