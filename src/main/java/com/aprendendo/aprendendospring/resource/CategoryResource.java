package com.aprendendo.aprendendospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendo.aprendendospring.entities.Category;
import com.aprendendo.aprendendospring.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return service.findAll();
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id) {
		Category ca = service.findById(id);
		return ResponseEntity.ok(ca);
		
	}
	
	
	
	

}
