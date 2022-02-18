package com.inventry.project.datasource2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.TokenBlackList;

public interface TokenBlackListRepository extends JpaRepository<TokenBlackList,Long>{

Boolean	existsByToken(String token);
}
