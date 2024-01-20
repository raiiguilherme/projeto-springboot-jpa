package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.Order;
import com.aprendendo.aprendendospring.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository; //associação com o repositorio
	
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = repository.findAll(); //cria uma lista do tipo order que recebe uma lista de orders vinda do metodo findAll do repository
		return ResponseEntity.ok(list);
	}
	
	public Order findById(long id) { //metodo do tipo Order que recebe por parametro o id da entidade desejada 
		Optional<Order> o = repository.findById(id); //Optional<Order> nomeado de "o" que recebe um metodo do repository que retorna um Optional de orders
		return o.get(); //retorna o objeto 
	}
	
	
	
	
	
	
}
