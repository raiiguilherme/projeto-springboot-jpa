package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.Product;
import com.aprendendo.aprendendospring.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	public Product findById(long id){
		Optional<Product> o = repository.findById(id);
		return o.get();
	}
	
	
}
