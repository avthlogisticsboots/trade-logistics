package com.internationaltrade.logistics.user.controller;

import com.internationaltrade.logistics.user.dto.LoginDto;
import com.internationaltrade.logistics.user.dto.RegisterRequestDto;
import com.internationaltrade.logistics.user.dto.UserResponseDto;
import com.internationaltrade.logistics.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody LoginDto loginDto) {
        UserResponseDto userResponseDto =  userService.login(loginDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        UserResponseDto userResponseDto =  userService.register(registerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long userId, @Valid @RequestBody RegisterRequestDto registerRequestDto) {
        UserResponseDto userResponseDto =  userService.updateUser(userId, registerRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
