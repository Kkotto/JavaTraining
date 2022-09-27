package org.example.service;

public class InfantException extends Exception{
    public InfantException(int age){
        super("Attention! Kid was found! Age is "+age);
    }
}
