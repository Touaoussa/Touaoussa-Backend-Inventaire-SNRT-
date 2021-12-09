package com.inventry.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventry.project.datasource2.repo.ArticleLocalRepository;
import com.inventry.project.datasource2.repo.IArticle;
import com.inventry.project.model.Article;

@Service
@Transactional
public class ArticleService {

	@Autowired 
	ArticleLocalRepository articleLocalrepository ;
	
	public void updatearticles(List<Article> articles) {
		
		for(int i=0 ; i< articles.size() ; i++) {
			Article article = this.articleLocalrepository.findById(articles.get(i).getIdarticle()).get();
			article.setLot(articles.get(i).getLot());
			article.setCodebare(articles.get(i).getCodebare());
			article.setComplement_intitule(articles.get(i).getComplement_intitule());
			article.setDescription(articles.get(i).getDescription());
			article.setMarque(articles.get(i).getMarque());
			article.setType(articles.get(i).getType());
			article.setNsr(articles.get(i).getNsr());
			article.setCaracteristiques(articles.get(i).getCaracteristiques());
			System.out.println("nsr= "+articles.get(i).getNsr());
			article.setObservation(articles.get(i).getObservation());
			article.setRI(articles.get(i).getRI());
			article.setImmobilisation(articles.get(i).getImmobilisation());
			article.setPv(articles.get(i).getPv());
			this.articleLocalrepository.save(article);
		}
	}
	
	public List<IArticle> getallarticles(){
		return this.articleLocalrepository.getallarticles();
	}
	
	
}
