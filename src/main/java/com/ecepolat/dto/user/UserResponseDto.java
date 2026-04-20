package com.ecepolat.dto.user;

import com.ecepolat.enums.Role;

import java.time.LocalDateTime;

public record UserResponseDto(
        Long id,
        String name,
        String email,
        Role role,
        LocalDateTime createdAt) {
}
