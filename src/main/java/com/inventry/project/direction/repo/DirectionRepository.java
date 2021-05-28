package com.inventry.project.direction.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.inventry.project.model.Direction;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {

	Direction findByIntitule(String intitule);
	
	
}
