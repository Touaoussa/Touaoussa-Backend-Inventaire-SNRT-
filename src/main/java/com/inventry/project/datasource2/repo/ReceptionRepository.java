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
	List<Reception> findBysupportreference(@Param("ref")Long reference);
	
	@Query(value="delete  from reception r \r\n" + 
			"where r.support_id =:ref "  ,nativeQuery = true)
	List<Reception> deleteBysupportreference(@Param("ref")Long reference);
	
		
}
