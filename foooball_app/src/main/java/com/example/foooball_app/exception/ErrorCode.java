package com.example.foooball_app.exception;

public enum ErrorCode {
USER_EXISTED(2,"USER EXISTED"),
    SPONSOR_EXISTED(2,"Đã tồn tại nhà tài trợ này"),

    COACH_EXISTED(2,"Đã tồn tại huấn luyện viên này"),
    TOURNAMENT_EXISTED(2,"Đã tồn tại giải đấu này"),

    USER_UNEXISTED(2,"Không tìm thấy người dùng này"),

    COACH_UNEXISTED(2,"Không tìm thấy huấn luyện viên này"),

    TOURNAMENT_UNEXISTED(2,"Không tìm thấy giải đấu này"),

    SPONSOR_UNEXISTED(2,"Không tìm nhà tài trợ này");




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
