package com.inventry.project.articlejde.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventry.project.model.Article;
import com.inventry.project.model.Supportacquistion;

public interface ArticleJdeRepository  extends JpaRepository<Article,Long> {
	
	
	
	/*@Query(value=""
			+ "select PDAN8 as numarticle  from proddta.F4311 \r\n"
			,nativeQuery = true)*/
	@Query(value="select  PDITM as numarticle, PDLITM as nomarticle, PDDSC1 as description, PDUORG as quantite, PDPRRC as prixunitaire, PDAEXP as prixtotal  from proddta.F4311 where PDDCTO=:type and  PDDOCO= :numsupport "
			,nativeQuery = true)
	List<Article> getarticles(@Param("numsupport") Long numsupport,
			@Param("type") String type
			);

}
