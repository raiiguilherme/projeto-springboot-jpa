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

@RestController	//indica que é um controller da API (deve estar em todas as classes que resources)
@RequestMapping(value="/users") //indica o caminho da requisição
public class UserResource {
	@Autowired
	private UserService service;
	
	@GetMapping //indica que é uma requisição get
	public ResponseEntity<List<User>> findAll(){
			return service.findAll();	//expoe a requisição
	
	}
	
	@GetMapping(value = "/{id}") //altera o URL para que seja filtrado por ID
	public ResponseEntity<User> findById(@PathVariable long id){ //anotação que passa o id informado no URL para o parametro "long id"
		User obj = service.findById(id);	//cria um objeto do tipo user recebendo o metodo da classe UserService
		return ResponseEntity.ok(obj);		//retorna esse objeto no corpo da nossa requisição
	}
	
	
}
