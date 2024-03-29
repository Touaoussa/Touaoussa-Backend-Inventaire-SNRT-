package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventry.project.model.Pvreception;

public interface PvRepository extends JpaRepository<Pvreception ,Long> {

	@Query(value="select pv.numpv as numpv, pv.date_pv as datepv, pv.utilisateur as utilisateur, pv.bonlivraison_id as numbl ,a.support_id as support_id , st.intitule as intitule,st.codification as codification , l.quantite as quantite , a.numarticle as numarticle ,a.immobilisation as immobilisation, a.description as description , a.nomarticle as nomarticle , a.prixunitaire as prixunitaire , a.prixtotal as prixtotal , a.codebare as codebare ,a.marque as marque , a.type as type,a.nsr as nsr , a.observation as observation ,a.RI as ri ,a.complement_intitule as complement_intitule, a.Lot as lot, a.caracteristiques as caracteristiques  from pvreception pv , reception r, article a , livraison l   ,site st\r\n" + 
			"where pv.reception_id=r.id_reception \r\n" + 
			"and r.id_reception=l.reception_id \r\n" + 
			"and l.article_id=a.idarticle \r\n "+			
			"and st.codification=r.site_id",nativeQuery = true )
	List<IHistoriquepv> gethstoriquepv();
	
	/*@Query(value="select pv.numpv as numpv, ut.nom , ut.prenom ,pv.date_pv as datepv, pv.utilisateur as utilisateur, pv.bonlivraison_id as numbl ,a.support_id as support_id , st.intitule as intitule,st.codification as codification , l.quantite as quantite , a.numarticle as numarticle , a.description as description , a.nomarticle as nomarticle , a.prixunitaire as prixunitaire , a.prixtotal as prixtotal , a.codebare as codebare ,a.marque as marque , a.type as type , a.observation as observation ,a.RI as ri ,a.complement_intitule as complement_intitule, a.Lot as lot, a.caracteristiques as caracteristiques  from pvreception pv ,utilisateur ut , agentspv agpv , reception r, article a , livraison l   ,site st\r\n" + 
			"where pv.reception_id=r.id_reception \r\n" + 
			"and r.id_reception=l.reception_id \r\n" + 
			"and l.article_id=a.numarticle \r\n "+			
			"and st.codification=r.site_id \r\n"+
			"and pv.numpv=agpv.pv_id \r\n" + 
			"and agpv.agent_id=ut.matricule",nativeQuery = true )
	List<IHistoriquepv> gethstoriquepv();*/
	
	@Query(value="select pv.numpv, ut.nom , ut.prenom from utilisateur ut , agentspv agpv , pvreception pv \r\n"
			+ "where pv.numpv=agpv.pv_id \r\n"
			+ "and agpv.agent_id=ut.matricule",nativeQuery = true )
	List<IAgents> getagents();
	
	
	
	@Query(value="select convert(SUBSTRING(numpv,5,4),SIGNED) as NUM from   pvreception  \r\n"
			+ "ORDER BY num desc limit 1 ",nativeQuery = true )
	Long getNumpv();
}
