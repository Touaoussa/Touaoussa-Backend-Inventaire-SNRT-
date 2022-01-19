package com.inventry.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventry.project.datasource2.repo.IArticle;
import com.inventry.project.model.Article;
import com.inventry.project.model.Pvreception;
import com.inventry.project.service.ArticleService;

//@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired 
	ArticleService articleservice;

	@GetMapping(path="/getallarticles")
		public List<IArticle> getallarticles() throws Exception {
		return this.articleservice.getallarticles();
	}
	 @PostMapping(path = "/updatearticles") 
	    public void AddPv(@RequestBody List<Article> articles) throws Exception{	
		this.articleservice.updatearticles(articles);
		}

}
