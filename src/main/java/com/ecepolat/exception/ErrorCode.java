package com.ecepolat.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USER_NOT_FOUND("USR_001", "Kullanıcı bulunamadı", HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_EXISTS("USR_002", "Bu email zaten kullanılıyor", HttpStatus.CONFLICT),
    OLD_PASSWORD_IS_WRONG("USR_003", "Eski şifre hatalı", HttpStatus.UNAUTHORIZED),
    PASSWORD_IS_WRONG("USR_004", "Şifre hatalı veya yetkisiz işlem", HttpStatus.UNAUTHORIZED),
    TASK_NOT_FOUND("TSK_001", "Task bulunamadı", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_FOUND("CAT_001", "Kategori bulunamadı", HttpStatus.NOT_FOUND),
    CATEGORY_ALREADY_EXISTS("CAT_002", "Bu kategori zaten mevcut", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED("AUTH_001", "Yetkisiz İşlem", HttpStatus.UNAUTHORIZED),
    VALIDATION_ERROR("VAL_001", "Doğrulama hatası", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
