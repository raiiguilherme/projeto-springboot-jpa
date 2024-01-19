package com.aprendendo.aprendendospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.aprendendospring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
