package com.aprendendo.aprendendospring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {//deve estender o RuntimeException


    public ResourceNotFoundException(Object id){    //construtor da classe de exceção
        super("Resource not found. Id"+id);



    }


    
}
