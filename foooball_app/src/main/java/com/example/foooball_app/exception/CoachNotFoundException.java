package com.example.foooball_app.exception;

public class CoachNotFoundException extends RuntimeException{
    public CoachNotFoundException(Long id) {
        super("Could not find coach with id " + id);
    }
}
