package com.aprendendo.aprendendospring.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.services.UserService;

@RestController
@RequestMapping(value="/users") //indica o caminho da requisição
public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping //indica que é uma requisição get
	public ResponseEntity<List<User>> findAll(){
			return service.findAll();	//expoe a requisição
	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable long id){
		User obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	
}
