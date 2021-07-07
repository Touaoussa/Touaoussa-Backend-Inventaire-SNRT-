package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Site;
import com.inventry.project.model.Supportacquistion;

public interface SiteRepository extends JpaRepository<Site,Long>  {

}
