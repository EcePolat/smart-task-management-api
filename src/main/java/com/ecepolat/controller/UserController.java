package com.ecepolat.controller;

import com.ecepolat.common.response.RootEntity;
import com.ecepolat.dto.user.ChangePasswordRequestDto;
import com.ecepolat.dto.user.UserResponseDto;
import com.ecepolat.dto.user.UserUpdateRequestDto;
import com.ecepolat.entity.User;
import com.ecepolat.security.CustomUserDetails;
import com.ecepolat.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController extends RestBaseController{

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public RootEntity<UserResponseDto> getUserById(@PathVariable Long id){
        return ok(userService.getUserById(id));
    }

    @PatchMapping("/change-password")
    public RootEntity<String> changePassword(Authentication authentication,
                                             @Valid @RequestBody ChangePasswordRequestDto request){
        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();

        userService.changePassword(email, request);
        return ok("Şifre başarıyla değiştirildi.");
    }

    @DeleteMapping("/{id}")
    public RootEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ok("Kullanıcı başarıyla silindi.");
    }
}
