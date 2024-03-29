package com.aprendendo.aprendendospring.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.aprendendo.aprendendospring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity		//identifica essa classe como sendo uma tabela do nosso banco de dados
@Table (name="tb_order")	//adiciona o nome dessa tabela
public class Order implements Serializable { //muito importante implementar o serializable

	
	private static final long serialVersionUID = 1L;
	
	
	@Id				//identifica que esse atributo é um ID da tabela e define logo a baixo a estrategia de geração dele (Neste caso seria o AUTOINCREMENT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private Integer orderStatus;


	
	
	@ManyToOne		//define a relação das nossa entidades (no caso esta tendo uma relação muitos para um com a nossa entidade User)
	@JoinColumn(name="client_id")	//define o nome dessa chave estrangeira
	private User clients;

	@OneToMany(mappedBy = "id.order") //id.order porque a classe ordem item é quem tem o id que se relaciona com o OrderItemPK
	private Set<OrderItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)//relação um para um nós mapeamos as entidades para terem o mesmo id
	private Payment payment;
	
	
	public Order() {
	
	}

	public Set<OrderItem> getItems(){ //get do relacionamento
		return items;
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
	
	@JsonIgnore			//jsonignore no getUsuario para que nao ocorra um loop
	public User getUsers() {
		return clients;
	}

	public void setClients(User clients) {
		this.clients = clients;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getTotal(){
		double sum =0;
		for(OrderItem x : items){
			sum += x.getSubTotal();
		}
		return sum;
	}





	public OrderStatus getOrderstatus() {
		return OrderStatus.valueOf(orderStatus); //retorna 
	}

	public void setOrderstatus(OrderStatus orderStatus) {
		if(orderStatus != null) { //verifica se é nulo
		this.orderStatus = orderStatus.getCode(); //atribui
		}
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
	
	public Order(Instant moment, OrderStatus orderstatus, User clients) {
		
		this.moment = moment;
		this.clients = clients;
		setOrderstatus(orderstatus);
		
	}
	
	
	
	
	
	
}
