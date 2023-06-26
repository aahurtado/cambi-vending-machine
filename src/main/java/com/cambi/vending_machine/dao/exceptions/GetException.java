package com.cambi.vending_machine.dao.exceptions;

public class GetException extends RuntimeException{
    public GetException(Throwable cause) {
        super(cause);
    }
    public GetException(String msg){super(msg);}
}
