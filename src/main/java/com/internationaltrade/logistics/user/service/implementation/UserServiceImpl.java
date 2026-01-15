package com.internationaltrade.logistics.user.service.implementation;

import com.internationaltrade.logistics.exception.UserNotFoundException;
import com.internationaltrade.logistics.user.dto.LoginDto;
import com.internationaltrade.logistics.user.dto.RegisterRequestDto;
import com.internationaltrade.logistics.user.dto.UserResponseDto;
import com.internationaltrade.logistics.user.entity.User;
import com.internationaltrade.logistics.user.repository.UserRepository;
import com.internationaltrade.logistics.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto login(LoginDto loginDto) {
        
        User user = userRepository
                .findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Invalid credential"));
        
        return new UserResponseDto(
                user.getId(), 
                user.getUserName(), 
                user.getEmail());
    }

    @Override
    public UserResponseDto register(RegisterRequestDto registerRequestDto) {
        User user = new User();
        user.setUserName(registerRequestDto.getName());
        user.setEmail(registerRequestDto.getEmail());
        user.setPassword(registerRequestDto.getPassword());
        
        User newUser = userRepository.save(user);
        
        return new UserResponseDto(
                newUser.getId(),
                newUser.getUserName(),
                newUser.getEmail());
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(Long userId, RegisterRequestDto registerRequestDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("Invalid user id : " + userId));
        
        if (registerRequestDto.getName() != null) user.setUserName(registerRequestDto.getName());
        if (registerRequestDto.getEmail() != null) user.setEmail(registerRequestDto.getEmail());
        if (registerRequestDto.getPassword() != null) user.setPassword(registerRequestDto.getPassword());
        
        User updatedUser = userRepository.save(user);
        
        return new UserResponseDto(
                updatedUser.getId(),
                updatedUser.getUserName(),
                updatedUser.getEmail()
        );
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("Invalid user id : " + userId));

        userRepository.delete(user);
    }

}
