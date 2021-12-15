package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventry.project.model.Article;
import com.inventry.project.model.ArticleJde;


public interface ArticleLocalRepository extends JpaRepository<Article,Long> {
	
	
	
	
	
	
	
	@Query(value="select  a.numarticle, a.nomarticle , a.description ,a.type , a.codebare,a.nsr as nsr , a.support_id, s.intitule , pv.numpv from article a, article_pvreception ap  ,site s ,pvreception pv \r\n" + 
			"where a.idarticle=ap.articles_idarticle\r\n" + 
			"and ap.pvs_numpv=pv.numpv\r\n" + 
			"and	pv.site_id=s.codification \r\n" + 
			 "GROUP BY a.idarticle,a.codebare union\r\n" + 
			 "\r\n" + 
			 "select  d.numarticle, d.nomarticle , d.description ,d.type , d.codebare,a.nsr as nsr , a.support_id, s.intitule , pv.numpv from article a, article_pvreception ap  ,site s ,pvreception pv ,deatilsarticle d \r\n" + 
			 "where a.idarticle=ap.articles_idarticle\r\n" + 
			 "and ap.pvs_numpv=pv.numpv\r\n" + 
			 "and	pv.site_id=s.codification \r\n" + 
			 "and d.article_id=a.idarticle\r\n" + 
			 "GROUP BY a.idarticle,a.codebare",nativeQuery = true)
	List<IArticle> getallarticles();

}
