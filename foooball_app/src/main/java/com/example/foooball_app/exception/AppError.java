package com.example.foooball_app.exception;

public class AppError extends RuntimeException {
    public AppError(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public ErrorCode getErrCode() {
        return errorCode;
    }

    public void setErrCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
