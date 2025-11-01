package ru.ivanov.ecommerceplatformproject.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sqm.mutation.internal.temptable.UpdateExecutionDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.DeliveryAddressDto;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.AddDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.service.DeliveryAddressService;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestControllerV1 {

    private final UserService userService;
    private final DeliveryAddressService deliveryAddressService;

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser() {
        UUID userId = null; //todo получение из токена
        return userService.getUser(userId);
    }

    @PatchMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUserPatch(
            @Valid @RequestBody UpdateUserRequest request
    ) {
        UUID userId = null; //todo получение из токена
        return userService.updateUserPatch(userId, request);
    }


    @PostMapping("/me/addresses")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryAddressDto addDeliveryAddress(AddDeliveryAddressRequest request) {
        UUID userId = null; //todo получение из токена
        return deliveryAddressService.addDeliveryAddress(userId, request);
        //todo location
    }

    @GetMapping("/me/addresses")
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryAddressDto> getAllUserDeliveryAddresses() {// пока без паинации
        UUID userId = null; //todo получение из токена
        return deliveryAddressService.getAllUserDeliveryAddress(userId);
    }

    @PatchMapping("/me/addresses/{deliveryAddressId}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryAddressDto updateDeliveryAddress(UpdateDeliveryAddressRequest request) {
        return deliveryAddressService.updateDeliveryAddress(request);
    }

    @DeleteMapping("/me/addresses/{deliveryAddressId}")
    public void deleteUserDeliveryAddress(@PathVariable("deliveryAddressId") UUID deliveryAddressId) {
        deliveryAddressService.deleteDeliveryAddress(deliveryAddressId);
    }
}