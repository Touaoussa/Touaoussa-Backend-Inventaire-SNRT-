package com.inventry.project.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.transaction.TransactionRolledbackException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import com.inventry.project.Exception.DuplicateCDBException;
import com.inventry.project.datasource2.repo.ArticleLocalRepository;
import com.inventry.project.datasource2.repo.DetailsArticleRepository;
import com.inventry.project.datasource2.repo.IArticle;
import com.inventry.project.model.Article;
import com.inventry.project.model.DeatilsArticle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
@Service
//@Transactional
public class ArticleService {

	@Autowired 
	ArticleLocalRepository articleLocalrepository ;
 
	/*@Autowired
    private SessionFactory sessionFactory;
	
	
	
	@Autowired 
	private LocalContainerEntityManagerFactoryBean  localContainerEntityManagerFactoryBean;*/
	
	@Autowired 
	DetailsArticleRepository detailsarticlerepository;
 
	public void updatearticles(List<Article> articles) throws Exception  {

		
		Session session = null;
	    Transaction transaction = null;
		for(int i=0 ; i< articles.size() ; i++) {
			Article article = this.articleLocalrepository.findById(articles.get(i).getIdarticle()).get();	
			article.setLot(articles.get(i).getLot());	 
			article.setComplement_intitule(articles.get(i).getComplement_intitule());
			//System.out.println("supp id = "+articles.get(i).getSupport());
			try {
				article.setCodebare(articles.get(i).getCodebare());	
				this.articleLocalrepository.flush();
			}catch(Exception e) {	
				//throw new Exception(e.getMessage());
				//throw new DuplicateCDBException("Le code barre "+articles.get(i).getCodebare()+" déja Existé");
			}
			article.setDescription(articles.get(i).getDescription());
			article.setMarque(articles.get(i).getMarque());
			article.setType(articles.get(i).getType());
			article.setNsr(articles.get(i).getNsr());
			article.setCaracteristiques(articles.get(i).getCaracteristiques());
			//System.out.println("nsr= "+articles.get(i).getNsr());
			article.setObservation(articles.get(i).getObservation());
			article.setRI(articles.get(i).getRI());
			article.setImmobilisation(articles.get(i).getImmobilisation());
			article.getPv().addAll(articles.get(i).getPv());
			System.out.println("detailsarticles size =" +articles.get(i).getDetailsarticle().size());
			//article.setPv();
			//article.getPv().addAll(articles.get(i).getPv());*/
			for(int j=0 ; j< articles.get(i).getDetailsarticle().size() ;j++ ) {
			DeatilsArticle detailsarticle =	articles.get(i).getDetailsarticle().get(j);
			String cb = detailsarticle.getCodebare();
			detailsarticle.setArticle(article);
			detailsarticle.setCodebare(null);
			detailsarticle = this.detailsarticlerepository.save(detailsarticle);
			try {
			detailsarticle.setCodebare(cb);
			this.detailsarticlerepository.flush();
			}catch(Exception e) {	
			throw new DuplicateCDBException("Le code barre "+detailsarticle.getCodebare()+" déja Existé");
			}
			}
			//System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");
			//article.setDetailsarticle(articles.get(i).getDetailsarticle()) ;
			//this.articleLocalrepository.flush();
			//System.out.println("cccccccccccccccccccccc");
			/*//throw new SQLIntegrityConstraintViolationException();
			*/
			/*try {
			article.setCodebare(articles.get(i).getCodebare());	
			//this.articleLocalrepository.save(article);
			this.articleLocalrepository.flush();
			}
			catch(Exception e) {	
				//throw new Exception(e.getMessage());
				throw new DuplicateCDBException("Le code barre "+articles.get(i).getCodebare()+" déja Existé");
			}*/
		}
	}
	
	public List<IArticle> getallarticles(){
		return this.articleLocalrepository.getallarticles();
	}
	
	
}
