package ru.ivanov.ecommerceplatformproject.userservice.dto.request;

public record AddDeliveryAddressRequest(
        String fullName, // того кто будет получателем заказа
        String phone, // того кто будет получателем заказа
        String city,
        String street,
        String postalCode
) {
}