package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.repositories.UserRepository;
import com.aprendendo.aprendendospring.services.exceptions.ResourceNotFoundException;

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
		return u.orElseThrow(() -> new ResourceNotFoundException(id)); //para cada objeto vazio, lança essa exceção personalizada
		//u.orElseThrow (Se não encontrar esse objeto, ira lançar a exceção)
	}

	public User insert(User user){ //inserindo no banco de dados
		return repository.save(user); //apenas retornando o metodo repository.save que ja mostra por padrao o usuario inserido
	}

	public void delete(long id){
		repository.deleteById(id); //apenas chamando o metodo de deleção por id do repositorio
	}

	public User update(long id, User user){
		User entity = repository.getReferenceById(id); //prepara um objeto monitorado pelo jpa para que seja feita as alterações antes de jogar no banco
		updateData(entity, user); //metodo criado para atualizar os dados do entity no user
		return repository.save(entity);

	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail()); //coletando os dados do user e atribuindo ao entity
		entity.setPhone(user.getPhone());
	}

}
