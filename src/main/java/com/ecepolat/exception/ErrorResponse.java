package com.ecepolat.exception;

import java.util.List;

public class ErrorResponse {

    private String code;
    private String message;
    private List<String> errors;

    public ErrorResponse(String code, String message, List<String> errors){
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public ErrorResponse(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){ return code; }

    public String getMessage(){ return message; }

    public List<String> getErrors(){ return errors; }
}
