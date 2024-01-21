package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.Payment;
import com.aprendendo.aprendendospring.repositories.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    
    public ResponseEntity<List<Payment>> findAll(){
        List<Payment> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    public Payment findById(long id){
        Optional<Payment> p = repository.findById(id);
        return p.get();
    
    }
    
    
}
