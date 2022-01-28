package com.inventry.project.datasource2.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventry.project.model.Supportacquistion;
import com.inventry.project.model.Supportacquistionlocal;


@Repository
public interface SupportacquistionRepository2 extends JpaRepository<Supportacquistion,Long> {

	@Query(value="select * from supportacquistion sp ,site s, supportacquistion_site st\r\n" + 
			"where sp.reference = st.supports_reference\r\n" + 
			"and st.sites_codification=s.codification\r\n" + 
			"and s.responsable_id=:mat" ,nativeQuery = true)
	List<Supportacquistion> getsupportsbyresponsable(@Param("mat")Long matricule);
	
	@Query(value="select * from site s, supportacquistion sp, supportacquistion_site st\r\n" + 
			"where s.codification= st.sites_codification\r\n" + 
			"and  st.supports_reference=sp.reference\r\n" + 
			"and s.codification=:code" ,nativeQuery = true)
	List<Supportacquistion> getsupportsbysite(@Param("code")Long codesite);
	
	
	Supportacquistion findByReference(String reference);
	
	Boolean existsByReference(String reference); 
	
}
