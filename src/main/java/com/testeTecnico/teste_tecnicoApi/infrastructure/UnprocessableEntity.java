package com.testeTecnico.teste_tecnicoApi.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity (String mensagem) {
        super(mensagem);}
}
