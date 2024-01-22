package com.aprendendo.aprendendospring.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aprendendo.aprendendospring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //para que seja capaz de captar a exceção e fazer o tratamento presente no metodo abaixo 
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

        String error ="Resource not found"; //mensagem de erro para o usuario
        HttpStatus status = HttpStatus.NOT_FOUND; //tipo enumerado que mostra o status da exceção


        //construindo um novo objeto da classe que criamos, que contem os valores que aparecera para o usuario la no JSON
        //instant.now (mostra o momento do erro)
        //status.value (mostra o status do erro)
        //erro (mostra a mensagem que nos criamos no começo do metodo)
        //e.getmessage (pega a mensagem da classe de exceção que criamos e mostra no corpo da exceção)
        //request.getresquestURI (captura o caminho que apresentou o erro)
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);



    }


    
}
