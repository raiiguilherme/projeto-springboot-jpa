package com.aprendendo.aprendendospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.aprendendospring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
