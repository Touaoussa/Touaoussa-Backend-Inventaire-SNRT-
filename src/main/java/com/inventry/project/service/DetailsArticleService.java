package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.DetailsArticleRepository;
import com.inventry.project.model.DeatilsArticle;

@Service
@Transactional
public class DetailsArticleService {
	@Autowired
	DetailsArticleRepository detailsarticlerepository;
	
	public List<DeatilsArticle> adddetailsarticle(List<DeatilsArticle> details){
		return this.detailsarticlerepository.saveAll(details);
	}

}
