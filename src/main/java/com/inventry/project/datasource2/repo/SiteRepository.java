package com.inventry.project.datasource2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;

public interface SiteRepository extends JpaRepository<Site,Long>  {
	
	@Query(value="select * from site s, utilisateur u\r\n" + 
			"where s.responsable_id = u.matricule\r\n" + 
			"and u.matricule=:mat" ,nativeQuery = true)
	List<Site> getsitebyresponsable(@Param("mat")Long matricule);

}
