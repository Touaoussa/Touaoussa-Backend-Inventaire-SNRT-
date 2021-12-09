package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventry.project.model.Article;
import com.inventry.project.model.HistoriqueLivraison;
import com.inventry.project.model.Livraison;
import com.inventry.project.model.LvraisonKey;
import com.inventry.project.model.Reception;
import com.inventry.project.model.Site;

public interface LivraisonRepository extends JpaRepository<Livraison,LvraisonKey> {

	//public long deleteByReceptionAndArticle(long firstId ,long secondId);
	public long deleteByReceptionAndArticle(Reception reception ,Article article);
	//void deleteByIdReceptionIdAndArticleId(long firstId , long secondId);
	
	@Query(value="select l.article_id from reception r, livraison l \r\n" + 
			"where l.reception_id=r.id_reception \r\n" + 
			"and r.id_reception=:numreception" ,nativeQuery = true)
	List<Long> getnumarticles(@Param("numreception")Long numreception);
	
	@Query(value="select r.id_reception as idreception , l.quantite as quantite , a.numarticle as numarticle , a.description as description , a.nomarticle as nomarticle , a.prixunitaire as prixunitaire , a.prixtotal as prixtotal, a.codebare as codebare, a.marque as marque  from reception r,livraison l, article a \r\n" + 
			"where r.id_reception=l.reception_id \r\n" + 
			"and l.article_id=a.idarticle \r\n "+
			"and r.support_id=:reference " ,nativeQuery = true )
	List<IHistoriqueLivraison> gethstoriquelivraison(@Param("reference")Long reference);
}
