package com.aprendendo.aprendendospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.aprendendospring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
