package ru.ivanov.ecommerceplatformproject.userservice.service;

import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.sharedlibs.event.UserRegisteredEvent;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;

import java.util.UUID;

public interface UserService {
    void createUser(UserRegisteredEvent event);

    UserDto getUser(UUID userId);

    UserDto updateUserPatch(UUID userId, UpdateUserRequest request);
}