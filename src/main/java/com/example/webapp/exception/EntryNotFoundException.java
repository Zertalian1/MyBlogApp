package com.example.webapp.exception;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(int id) {
        super("Could not find entry " + id);
    }
}
