package com.aprendendo.aprendendospring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity			//dizendo que essa classe representa uma entidade do nosso banco 
@Table(name="tb_user")	//dando um nome 
public class User implements Serializable {//muito importante implementar o Serializable
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "clients")	//define a relação "UM PARA MUITOS" na nossa relação com a entidade Order, 
	private List<Order> orders = new ArrayList<>();	 //e direciona que na nossa entidade Order, o atributo que é a chave estrangeira é o "clients"
	
	
	
	
	@Id	//anotação que identifica como ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerando o autoincrement
	private long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	public User(long id, String name, String email, String phone, String password) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public User(String name, String email, String phone, String password) {
		
	
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		
	}
	public List<Order> getOrders() {
		return orders;
	}
	
	
	
}
