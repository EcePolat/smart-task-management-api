package com.ecepolat.service;

import com.ecepolat.dto.auth.AuthResponseDto;
import com.ecepolat.dto.auth.LoginRequestDto;
import com.ecepolat.dto.auth.RegisterRequestDto;

public interface AuthService {
    AuthResponseDto register(RegisterRequestDto request);
    AuthResponseDto login(LoginRequestDto request);

}
