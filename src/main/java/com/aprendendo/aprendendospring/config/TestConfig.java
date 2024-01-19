package com.aprendendo.aprendendospring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.repositories.UserRepository;

@Configuration //dizendo para o spirng que é uma classe de configuração
@Profile("test") //profile do spring vindo do application.properties
public class TestConfig implements CommandLineRunner{
	@Autowired	//gerenciando a dependencia 	
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Luciana", "euluciana@gmail.com", "321312312", "dsadas");
		User u2 = new User("Luciana", "euluciana@gmail.com", "234524", "dsadas");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
