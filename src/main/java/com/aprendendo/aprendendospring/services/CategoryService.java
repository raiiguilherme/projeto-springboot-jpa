package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.Category;
import com.aprendendo.aprendendospring.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = repository.findAll();
		return ResponseEntity.ok(list);
		
	}
	
	public Category findById(long id) {
		Optional<Category> ca = repository.findById(id);
		return ca.get();
		
	}
	
	
	

}
