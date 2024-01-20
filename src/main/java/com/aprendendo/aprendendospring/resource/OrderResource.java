package com.aprendendo.aprendendospring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aprendendo.aprendendospring.entities.Order;
import com.aprendendo.aprendendospring.services.OrderService;

@RestController		//indica que a classe é um controller da API
@RequestMapping(value="/orders")	//indica o URL responsavel pela requisição
public class OrderResource {
	
	@Autowired
	private OrderService service;	//associação do a OrderService
	
	@GetMapping //indica que vai ser chamado por uma requisição GET
	public ResponseEntity<List<Order>> findAll(){	//lista todos os campos 
		return service.findAll();	
	}
	
	@GetMapping(value="/{id}")	//altera o URL para que seja filtrado por ID 
	public ResponseEntity<Order> findById(@PathVariable long id){
		Order o = service.findById(id);	//cria um objeto do tipo order recebendo um metodo da Classe OrderService
		return ResponseEntity.ok(o);	//retorna esse objeto no corpo da nossa requisição
		
	}

}
