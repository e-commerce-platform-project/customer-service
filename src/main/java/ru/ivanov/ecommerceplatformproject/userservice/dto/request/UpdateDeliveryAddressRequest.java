package ru.ivanov.ecommerceplatformproject.userservice.dto.request;

import java.util.UUID;

public record UpdateDeliveryAddressRequest(
        UUID deliveryAddressId,
        String city,
        String street,
        String postalCode
) {
}