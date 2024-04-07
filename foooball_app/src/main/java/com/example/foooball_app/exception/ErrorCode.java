package com.example.foooball_app.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
public enum ErrorCode {
    USER_EXISTED(2,"USER EXISTED", HttpStatus.BAD_REQUEST),
    SPONSOR_EXISTED(2,"Đã tồn tại nhà tài trợ này", HttpStatus.BAD_REQUEST),
    USER_UNEXISTED(2,"Không tìm thấy người dùng này", HttpStatus.BAD_REQUEST),
    SPONSOR_UNEXISTED(2,"Không tìm nhà tài trợ này", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR);
    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
    public int getCode() {
        return code;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }
}
