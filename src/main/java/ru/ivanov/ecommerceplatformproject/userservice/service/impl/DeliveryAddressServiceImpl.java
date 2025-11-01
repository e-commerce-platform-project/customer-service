package ru.ivanov.ecommerceplatformproject.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.DeliveryAddressDto;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.AddDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.entity.DeliveryAddress;
import ru.ivanov.ecommerceplatformproject.userservice.mapper.DeliveryAddressMapper;
import ru.ivanov.ecommerceplatformproject.userservice.repository.DeliveryAddressRepository;
import ru.ivanov.ecommerceplatformproject.userservice.service.DeliveryAddressService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepository repository;
    private final DeliveryAddressMapper mapper;

    @Override
    public DeliveryAddressDto addDeliveryAddress(UUID userId, AddDeliveryAddressRequest request) {
        DeliveryAddress address = mapper.toEntity(userId, request);
        DeliveryAddress savedAddress = repository.save(address);
        return mapper.toDto(savedAddress);
    }

    @Override
    public List<DeliveryAddressDto> getAllUserDeliveryAddress(UUID userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public DeliveryAddressDto updateDeliveryAddress(UpdateDeliveryAddressRequest request) {
        DeliveryAddress address = repository.findById(request.deliveryAddressId())
                .orElseThrow();//todo исключение и получение с блокировкой

        //update

        DeliveryAddress updatedAddress = repository.save(address);
        return mapper.toDto(updatedAddress);
    }

    @Override
    @Transactional
    public void deleteDeliveryAddress(UUID deliveryAddressId) {
        // удаление
    }
}
