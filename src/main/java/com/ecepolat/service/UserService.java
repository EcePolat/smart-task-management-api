package com.ecepolat.service;

import com.ecepolat.dto.user.ChangePasswordRequestDto;
import com.ecepolat.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto getUserById(Long id);

    void changePassword(Long id, ChangePasswordRequestDto request);

    void deleteUser(Long id);
}
