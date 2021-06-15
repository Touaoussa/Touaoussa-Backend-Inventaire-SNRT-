package com.inventry.project.datasource2.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventry.project.model.Supportacquistion;
import com.inventry.project.model.Supportacquistionlocal;


@Repository
public interface SupportacquistionRepository2 extends JpaRepository<Supportacquistionlocal,Long> {

	
}
