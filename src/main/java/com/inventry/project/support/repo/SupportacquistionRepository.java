package com.inventry.project.support.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventry.project.model.Supportacquistion;


@Repository
public interface SupportacquistionRepository extends JpaRepository<Supportacquistion,Long> {

	@Query(value="select a.phdoco AS reference,a.phdcto AS type  from proddta.f4301 a" ,nativeQuery = true)
	List<Supportacquistion> getsupports();
}
