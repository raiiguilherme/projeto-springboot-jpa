package com.aprendendo.aprendendospring.resource;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendo.aprendendospring.entities.User;

@RestController
@RequestMapping(value="/users") //indica o caminho da requisição
public class UserResource {
	@GetMapping //indica que é uma requisição get
	public ResponseEntity<User> findAll(){
		
		User u = new User(1, "Luciana", "euluciana@gmail.com", "99999999", "1234323");
		return ResponseEntity.ok().body(u);	//expoe a requisição
	
	}
	
	
}
