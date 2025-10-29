package ru.ivanov.ecommerceplatformproject.userservice.service;

import jakarta.validation.Valid;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.request.LoginRequest;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.response.ApiResponse;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.response.ApiTokenResponse;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UserRegistrationRequest;

import java.util.UUID;

public interface UserService {
    ApiResponse createUser(UserRegistrationRequest request);

    UserDto verifyCredentials(String username, String password);

    UserDto getUser(UUID userId);

    UserDto updateUserPatch(UUID userId, UpdateUserRequest request);

    void deleteUserById(UUID userId);

    ApiTokenResponse login(LoginRequest request);
}