package com.ecepolat.dto.auth;

public record AuthResponseDto(
        String accessToken,
        String refreshToken,
        String tokenType) {
}
