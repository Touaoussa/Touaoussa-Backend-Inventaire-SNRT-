package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventry.project.model.Article;
import com.inventry.project.model.ArticleJde;


public interface ArticleLocalRepository extends JpaRepository<Article,Long> {
	
	@Query(value="select  a.numarticle, a.nomarticle , a.description ,a.type , a.codebare,a.nsr as nsr , a.support_id, s.intitule , pv.numpv from article a, livraison l , reception r ,site s ,pvreception pv\r\n" + 
			"where a.numarticle=l.article_id\r\n" + 
			"and l.reception_id=r.id_reception\r\n" + 
			"and r.site_id=s.codification\r\n" + 
			"and pv.reception_id=r.id_reception "
			+ "GROUP BY a.codebare",nativeQuery = true)
	List<IArticle> getallarticles();

}
