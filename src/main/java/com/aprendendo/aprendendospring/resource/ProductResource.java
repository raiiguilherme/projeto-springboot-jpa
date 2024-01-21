package com.aprendendo.aprendendospring.resource;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendo.aprendendospring.entities.Product;
import com.aprendendo.aprendendospring.services.ProductService;



@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return service.findAll();
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable long id){
		Product o = service.findById(id);
		return ResponseEntity.ok(o);
		
	}


	
	
	
}
