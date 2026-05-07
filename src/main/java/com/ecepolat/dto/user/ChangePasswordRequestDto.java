package com.ecepolat.dto.user;

public record ChangePasswordRequestDto(String oldPassword,
                                        String newPassword) {
}
