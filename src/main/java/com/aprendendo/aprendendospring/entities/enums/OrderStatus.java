package com.aprendendo.aprendendospring.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), //definindo o inteiro relacionado
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; //variavel que vai guardar os inteiros

	private OrderStatus(int code) { //construtor 
		this.code = code;
		
	}
	
	public int getCode(){	//metodo que retorna o codigo
		return code;
	}
	
	public static OrderStatus valueOf(int code) { 
		for(OrderStatus or : OrderStatus.values()) { //recebe por argumento um code, percorre todo o ENUM e retorna o enum de code igual ao passado por argumento
			if(or.getCode() == code) {
				return or;
			}
		}
		throw new IllegalArgumentException("Code Invalid"); //exceção
		
	}
	
	
	
	
}
