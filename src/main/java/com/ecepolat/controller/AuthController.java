package com.ecepolat.controller;

import com.ecepolat.common.response.RootEntity;
import com.ecepolat.dto.auth.AuthResponseDto;
import com.ecepolat.dto.auth.LoginRequestDto;
import com.ecepolat.dto.auth.RegisterRequestDto;
import com.ecepolat.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends RestBaseController{

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public RootEntity<AuthResponseDto> register(@Valid @RequestBody RegisterRequestDto request){
        return ok(authService.register(request));
    }

    @PostMapping("/login")
    public RootEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto request){
        return ok(authService.login(request));
    }

}
