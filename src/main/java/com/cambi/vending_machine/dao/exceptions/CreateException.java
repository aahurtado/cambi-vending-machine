package com.cambi.vending_machine.dao.exceptions;

public class CreateException extends RuntimeException{
    public CreateException(Throwable cause) {
        super(cause);
    }
    public CreateException(String msg){super(msg);}
}

