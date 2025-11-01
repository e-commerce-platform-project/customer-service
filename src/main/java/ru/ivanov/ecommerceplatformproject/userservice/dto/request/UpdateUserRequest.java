package ru.ivanov.ecommerceplatformproject.userservice.dto.request;

public record UpdateUserRequest(
        String firstName,
        String lastName,
        String email, //todo по идее при обновлении почты надо снова ее верифицировать
        String phone,
        String passportSeries,
        String passportNumber
) {
}