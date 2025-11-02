package ru.ivanov.ecommerceplatformproject.userservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.DeliveryAddressDto;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.AddDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.entity.DeliveryAddress;

import java.util.UUID;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DeliveryAddressMapper {

    DeliveryAddressDto toDto(DeliveryAddress address);

    @Mapping(target = "user.id", source = "userId")
    DeliveryAddress toEntity(UUID userId, AddDeliveryAddressRequest request);
}