package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Reception;
import com.inventry.project.model.Region;

public interface RegionRepository extends JpaRepository<Region,Long>  {

}
