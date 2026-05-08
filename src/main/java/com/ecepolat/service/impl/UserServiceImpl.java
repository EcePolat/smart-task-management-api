package com.ecepolat.service.impl;

import com.ecepolat.dto.user.ChangePasswordRequestDto;
import com.ecepolat.dto.user.UserResponseDto;
import com.ecepolat.entity.User;
import com.ecepolat.exception.BusinessException;
import com.ecepolat.exception.ErrorCode;
import com.ecepolat.mapper.UserMapper;
import com.ecepolat.repository.UserRepository;
import com.ecepolat.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    private User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = findUserById(id);
        return userMapper.toResponseDto(user);
    }

    @Override
    public void changePassword(Long id, ChangePasswordRequestDto request) {
        User user = findUserById(id);

        if(!user.getPassword().equals(request.oldPassword())){
            throw new RuntimeException("Eski şifre hatalı");
        }

        user.setPassword(request.newPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }
}
