package com.aprendendo.aprendendospring.resource.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException (String msg){
        super(msg);
    }
    
}
