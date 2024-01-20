package com.aprendendo.aprendendospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.aprendendospring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
