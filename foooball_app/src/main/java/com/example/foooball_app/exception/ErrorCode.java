package com.example.foooball_app.exception;

public enum ErrorCode {
    USER_EXISTED(1001,"USER EXISTED");
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}