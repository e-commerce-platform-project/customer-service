package ru.ivanov.ecommerceplatformproject.userservice.dto.request;

public record UpdateUserRequest(
        String email,
        String firstName,
        String lastName
) {
}