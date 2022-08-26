package com.example.webapp.exception;

public class NoUniqueUserException extends RuntimeException{

    public NoUniqueUserException(){
        super("This user already exists");
    }
}
