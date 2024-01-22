package com.aprendendo.aprendendospring.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.repositories.UserRepository;
import com.aprendendo.aprendendospring.resource.exceptions.DatabaseException;
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

		if(!repository.existsById(id)){//verificando se retorna que o objeto nao existe
			//se não existir, lança essa exceção personalizada
			throw new ResourceNotFoundException(id);
		}

		try{
		repository.deleteById(id); //apenas chamando o metodo de deleção por id do repositorio
		}

		catch(DataIntegrityViolationException e){//acontece quando tentamos deletar um objeto que tem outros objetos associados a ele
			throw new DatabaseException(e.getMessage());
		}
		
			
		
		
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
