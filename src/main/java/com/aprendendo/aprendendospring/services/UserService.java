package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public ResponseEntity<List<User>>  findAll(){
		List<User> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	public User findById(long id){
		Optional<User> u = repository.findById(id);		
		return u.get();
		
	}

}
