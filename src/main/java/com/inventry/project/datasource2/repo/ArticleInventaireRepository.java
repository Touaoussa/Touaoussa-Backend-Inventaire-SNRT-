package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Article;
import com.inventry.project.model.Articleinventaire;

public interface ArticleInventaireRepository  extends JpaRepository<Articleinventaire,Long> {

}
