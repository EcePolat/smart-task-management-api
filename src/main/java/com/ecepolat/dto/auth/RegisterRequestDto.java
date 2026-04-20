package com.ecepolat.dto.auth;

public record RegisterRequestDto(
        String name,
        String email,
        String password) {
}
