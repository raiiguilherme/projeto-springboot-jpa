package com.aprendendo.aprendendospring.resource.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") //formatando o horario
    private Instant timestamp; //momento da exceção
    private Integer status; //status da exceção
    private String error; //mensagem de erro apresentada ao usuario
    private String message; //erro lançado pela exceção
    private String path; //caminho que deu uma exceção


    
}
