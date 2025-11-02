package ru.ivanov.ecommerceplatformproject.userservice.service;

import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.DeliveryAddressDto;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.AddDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateDeliveryAddressRequest;

import java.util.List;
import java.util.UUID;

public interface DeliveryAddressService {

    UUID addDeliveryAddress(UUID userId, AddDeliveryAddressRequest request);

    List<DeliveryAddressDto> getAllUserDeliveryAddress(UUID userId);

    DeliveryAddressDto updateDeliveryAddress(UUID deliveryAddressId, UpdateDeliveryAddressRequest request);

    void deleteDeliveryAddress(UUID deliveryAddressId);
}