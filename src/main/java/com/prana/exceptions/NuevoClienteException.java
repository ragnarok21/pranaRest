package com.prana.exceptions;

public class NuevoClienteException extends RuntimeException {
    private String message;

    public NuevoClienteException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
