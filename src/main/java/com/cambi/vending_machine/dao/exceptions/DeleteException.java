package com.cambi.vending_machine.dao.exceptions;

public class DeleteException extends RuntimeException{
    public DeleteException(Throwable cause) {
        super(cause);
    }
    public DeleteException(String msg) {
        super(msg);
    }
}