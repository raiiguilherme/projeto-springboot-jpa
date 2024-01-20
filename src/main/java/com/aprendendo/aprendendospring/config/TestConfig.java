package com.aprendendo.aprendendospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprendendo.aprendendospring.entities.Order;
import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.repositories.OrderRepository;
import com.aprendendo.aprendendospring.repositories.UserRepository;

@Configuration //dizendo para o spirng que é uma classe de configuração
@Profile("test") //profile do spring vindo do application.properties
public class TestConfig implements CommandLineRunner{
	@Autowired	//gerenciando a dependencia 	
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {	//criação de alguns dados para nossas tabelas
		User u1 = new User("Luciana", "euluciana@gmail.com", "321312312", "dsadas");
		User u2 = new User("Luciana", "euluciana@gmail.com", "234524", "dsadas");
		
		Order o1 = new Order(Instant.parse("2007-01-03T12:03:40Z"), u1);
		Order o2 = new Order(Instant.parse("2021-07-11T12:03:40Z"), u2);
		Order o3 = new Order(Instant.parse("2020-11-12T09:03:40Z"), u1);
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
}
