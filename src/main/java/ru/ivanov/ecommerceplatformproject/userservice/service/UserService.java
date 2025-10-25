package ru.ivanov.ecommerceplatformproject.userservice.service;

import ru.ivanov.ecommerceplatformproject.common.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.common.dto.request.UserRegistrationRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserRegistrationRequest request);

    UserDto verifyCredentials(String username, String password);

    UserDto getUser(UUID userId);

    UserDto updateUserPatch(UUID userId, UpdateUserRequest request);

    void deleteUserById(UUID userId);
}