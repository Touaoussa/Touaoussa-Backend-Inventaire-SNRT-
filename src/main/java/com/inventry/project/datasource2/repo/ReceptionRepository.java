package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Article;
import com.inventry.project.model.Reception;

public interface ReceptionRepository extends JpaRepository<Reception,Long> {

}
