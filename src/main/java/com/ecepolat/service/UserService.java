package com.ecepolat.service;

import com.ecepolat.dto.user.ChangePasswordRequestDto;
import com.ecepolat.dto.user.UserResponseDto;
import com.ecepolat.entity.User;

public interface UserService {

    UserResponseDto getUserById(Long id);

    void changePassword(String email, ChangePasswordRequestDto request);

    void deleteUser(Long id);
}
