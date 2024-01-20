package com.aprendendo.aprendendospring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aprendendo.aprendendospring.entities.Category;
import com.aprendendo.aprendendospring.entities.Order;
import com.aprendendo.aprendendospring.entities.Product;
import com.aprendendo.aprendendospring.entities.User;
import com.aprendendo.aprendendospring.entities.enums.OrderStatus;
import com.aprendendo.aprendendospring.repositories.CategoryRepository;
import com.aprendendo.aprendendospring.repositories.OrderRepository;
import com.aprendendo.aprendendospring.repositories.ProductRepository;
import com.aprendendo.aprendendospring.repositories.UserRepository;

@Configuration //dizendo para o spirng que é uma classe de configuração
@Profile("test") //profile do spring vindo do application.properties
public class TestConfig implements CommandLineRunner{
	@Autowired	//gerenciando a dependencia 	
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {	//criação de alguns dados para nossas tabelas
		User u1 = new User("Luciana", "euluciana@gmail.com", "321312312", "dsadas");
		User u2 = new User("Luciana", "euluciana@gmail.com", "234524", "dsadas");
		
		Category cat1 = new Category("Electronics");
		Category cat2 = new Category("Books");
		Category cat3 = new Category("Computers");
		
		Order o1 = new Order(Instant.parse("2007-01-03T12:03:40Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(Instant.parse("2021-07-11T12:03:40Z"),OrderStatus.CANCELED, u2);
		Order o3 = new Order(Instant.parse("2020-11-12T09:03:40Z"),OrderStatus.CANCELED, u1);
		
		
		Product p1 = new Product( "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product( "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product( "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product( "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product( "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
	
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2); //adicionando uma categoria a cada produto 
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));  //salvando tudo novamente para criar a conexao das categorias
		
		
	}
}
