package com.aprendendo.aprendendospring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity		//identifica essa classe como sendo uma tabela do nosso banco de dados
@Table (name="tb_order")	//adiciona o nome dessa tabela
public class Order implements Serializable { //muito importante implementar o serializable

	
	private static final long serialVersionUID = 1L;
	
	
	@Id				//identifica que esse atributo é um ID da tabela e define logo a baixo a estrategia de geração dele (Neste caso seria o AUTOINCREMENT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Instant moment;
	
	@JsonIgnore
	@ManyToOne		//define a relação das nossa entidades (no caso esta tendo uma relação muitos para um com a nossa entidade User)
	@JoinColumn(name="client_id")	//define o nome dessa chave estrangeira
	private User clients;
	
	public Order() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getUsers() {
		return clients;
	}

	public void setClients(User clients) {
		this.clients = clients;
	}

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
		Order other = (Order) obj;
		return id == other.id;
	}

	public Order(long id, Instant moment, User clients) {
		
		this.id = id;
		this.moment = moment;
		this.clients = clients;
	}
	
	public Order(Instant moment, User clients) {
		
		this.moment = moment;
		this.clients = clients;
	}
	
	
	
	
	
	
}
