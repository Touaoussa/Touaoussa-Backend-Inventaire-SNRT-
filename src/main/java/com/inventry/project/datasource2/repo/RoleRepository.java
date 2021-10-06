package com.inventry.project.datasource2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventry.project.model.ERole;
import com.inventry.project.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {

	Optional<Role> findByName(ERole name);
	
}
