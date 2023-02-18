package com.atcjw.result;

public enum CodeEnum {
    SUCCESS(20000, "success"),
    FAIL(500, "fail");

    public final int code;
    public final String message;

    CodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
