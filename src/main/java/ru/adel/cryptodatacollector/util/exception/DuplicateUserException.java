package ru.adel.cryptodatacollector.util.exception;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException(String msg){
        super(msg);
    }
}
