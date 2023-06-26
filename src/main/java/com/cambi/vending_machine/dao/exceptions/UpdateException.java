package com.cambi.vending_machine.dao.exceptions;

public class UpdateException extends  RuntimeException{
    public UpdateException(Throwable cause) {
        super(cause);
    }
    public UpdateException(String msg){super(msg);}
}
