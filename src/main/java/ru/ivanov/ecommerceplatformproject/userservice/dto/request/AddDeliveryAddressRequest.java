package ru.ivanov.ecommerceplatformproject.userservice.dto.request;

public record AddDeliveryAddressRequest(
        String city,
        String street,
        String postalCode
) {
}