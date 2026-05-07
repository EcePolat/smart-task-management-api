package com.ecepolat.controller;

import com.ecepolat.common.response.RootEntity;

public class RestBaseController {

    protected <T> RootEntity<T> ok(T data){
        return RootEntity.ok(data);
    }

    protected <T> RootEntity<T> error(String message){
        return RootEntity.error(message);
    }
}
