package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventry.project.model.Article;
import com.inventry.project.model.Reception;

public interface ReceptionRepository extends JpaRepository<Reception,Long> {

	@Query(value="select * from reception r \r\n" + 
			"where r.support_id =:ref "  ,nativeQuery = true)
	List<Reception> findBysupportreference(@Param("ref")String ref);
	
	@Query(value="delete  from reception r \r\n" + 
			"where r.support_id =:ref "  ,nativeQuery = true)
	List<Reception> deleteBysupportreference(@Param("ref")Long reference);
	
	@Query(value="select r.date_reception, r.support_id , r.type_reception , r.id_reception , l.quantite , a.numarticle from reception r,livraison l, article a \r\n" + 
			"where r.id_reception=l.reception_id \r\n" + 
			"and l.article_id=a.numarticle \r\n "+
			"and r.support_id=:reference" ,nativeQuery = true)
	List<Reception> gethstoriquelivraison(@Param("reference")Long reference);
}
