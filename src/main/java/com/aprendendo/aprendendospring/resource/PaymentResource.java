package com.aprendendo.aprendendospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendo.aprendendospring.entities.Payment;
import com.aprendendo.aprendendospring.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){

        return service.findAll();

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable long id){

        Payment p = service.findById(id);
        return ResponseEntity.ok(p);
        }
    
}
