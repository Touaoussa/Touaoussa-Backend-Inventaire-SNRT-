package com.inventry.project.datasource1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventry.project.model.Article;
import com.inventry.project.model.ArticleJde;
import com.inventry.project.model.Supportacquistion;

public interface ArticleJdeRepository  extends JpaRepository<ArticleJde,Long> {
	
	
	
	/*@Query(value=""
			+ "select PDAN8 as numarticle  from proddta.F4311 \r\n"
			,nativeQuery = true)*/
	@Query(value="select   PDITM as numarticle, PDLITM as nomarticle,PDAN8 as numfournisseur,b.ABALPH as fournisseur ,PDDSC1 as description, PDUORG /100 as quantite, PDPRRC /10000 as prixunitaire, PDAEXP /100 as prixtotal , PDDOCO as support_id from proddta.F4311 a , proddta.F0101 b"
			+ " where a.pdan8 = b.aban8 and PDDCTO=:type and  PDDOCO=:numsupport "
			,nativeQuery = true)
	List<ArticleJde> getarticles(@Param("numsupport") String numsupport,
			@Param("type") String type
			);
	
	
	@Query(value="select   PDITM as numarticle, PDLITM as nomarticle,PDAN8 as numfournisseur , b.ABALPH as fournisseur ,PDDSC1 as description, PDUORG /100 as quantite, PDPRRC /10000 as prixunitaire, PDAEXP /100 as prixtotal , PDVR01 as support_id from proddta.F4311 a , proddta.F0101 b"
			+ " where a.pdan8 = b.aban8  and  PDVR01 LIKE '%' || :numsupport || '%'  and PDDCTO=:type "
			,nativeQuery = true)
	
	List<ArticleJde> getarticlesMarche( String numsupport,	 String type);



	
	
	

}
