package com.ecepolat.service.impl;

import com.ecepolat.dto.auth.AuthResponseDto;
import com.ecepolat.dto.auth.LoginRequestDto;
import com.ecepolat.dto.auth.RegisterRequestDto;
import com.ecepolat.entity.User;
import com.ecepolat.enums.Role;
import com.ecepolat.exception.BusinessException;
import com.ecepolat.exception.ErrorCode;
import com.ecepolat.repository.UserRepository;
import com.ecepolat.security.JwtService;
import com.ecepolat.service.AuthService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    private AuthResponseDto generateAuthResponse(User user){
        String accessToken = jwtService.generateAccessToken(user.getEmail());
        String refreshToken = jwtService.generateRefreshToken(user.getEmail());
        return new AuthResponseDto(accessToken, refreshToken);
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {

        if(userRepository.existsByEmail(request.email())){
            throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);

        return generateAuthResponse(savedUser);
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(()-> new BusinessException(ErrorCode.USER_NOT_FOUND));

        if(!user.getPassword().equals(request.password())){
            throw new BusinessException(ErrorCode.PASSWORD_IS_WRONG);
        }

        return generateAuthResponse(user);
    }
}
