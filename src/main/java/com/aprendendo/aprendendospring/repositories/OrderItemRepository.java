package com.aprendendo.aprendendospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.aprendendospring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
