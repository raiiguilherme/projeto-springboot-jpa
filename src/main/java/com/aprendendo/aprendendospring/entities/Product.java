package com.aprendendo.aprendendospring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_product")
public class Product implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String description;
	private Double price;
	private String imhUrl;
	
	@JsonIgnore //previne um loop
	@ManyToMany
	@JoinTable(name="tb_product_category", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns = @JoinColumn(name = "id_category"))
	private Set<Category> categories = new HashSet<>(); //associação (MUITO IMPORTANTE USAR O SET E HASHSET PARA QUE NAO EXISTA DUAS CATEGORIAS PRO MESMO PRODUTO)
	//JoinTable (Cria uma tabela de associação, a qual demos o nome de tb_product_category)
	//joinColumns (cria uma coluna para nossa tabela de relações
	//@JoinColumn (Anotação responsavel por criar esse campo na nossa tabela la no banco de dados
	//inverseJoinColumns (faz o mesmo que o joinColumns, mas agora para o nosso outro lado da associação (Classe Category)
	
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImhUrl() {
		return imhUrl;
	}
	public void setImhUrl(String imhUrl) {
		this.imhUrl = imhUrl;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	
	
	
	
	
	public Product(String name, String description, Double price, String imhUrl) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imhUrl = imhUrl;
	}
	public Product() {
		super();
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
		Product other = (Product) obj;
		return id == other.id;
	}
	
	
	
	
	
	

}
