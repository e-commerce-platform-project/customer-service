package ru.ivanov.ecommerceplatformproject.userservice.dto.request;

public record UpdateDeliveryAddressRequest(
        String city,
        String street,
        String postalCode
) {
}