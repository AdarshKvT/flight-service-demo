package com.kvtsoft.flightservicedemo.exception;

public class InsufficientAmountException extends RuntimeException{
    public  InsufficientAmountException(String msg){
        super(msg);
    }
}
