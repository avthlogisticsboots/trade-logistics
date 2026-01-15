package com.internationaltrade.logistics.user.service;

import com.internationaltrade.logistics.user.dto.LoginDto;
import com.internationaltrade.logistics.user.dto.RegisterRequestDto;
import com.internationaltrade.logistics.user.dto.UserResponseDto;

public interface UserService {
    UserResponseDto login(LoginDto loginDto);

    UserResponseDto register(RegisterRequestDto registerRequestDto);

    UserResponseDto updateUser(Long userId, RegisterRequestDto registerRequestDto);

    void deleteUser(Long userId);
}
