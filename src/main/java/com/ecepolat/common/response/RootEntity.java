package com.ecepolat.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {

    private boolean success;
    private T data;
    private String message;

    public static <T> RootEntity<T> ok(T data){
        RootEntity<T> response = new RootEntity<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> RootEntity<T> error(String message){
        RootEntity<T> response = new RootEntity<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}
