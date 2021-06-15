package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.Article;


public interface ArticleLocalRepository extends JpaRepository<Article,Long> {

}
