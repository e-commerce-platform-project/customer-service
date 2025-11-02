package ru.ivanov.ecommerceplatformproject.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.DeliveryAddressDto;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.AddDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateDeliveryAddressRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.service.DeliveryAddressService;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestControllerV1 {

    private final UserService userService;
    private final DeliveryAddressService deliveryAddressService;

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasRole('USER')")
    public UserDto getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return userService.getUser(userId);
    }

    @PatchMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUserPatch(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody UpdateUserRequest request
    ) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return userService.updateUserPatch(userId, request);
    }

    @PostMapping("/me/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID addDeliveryAddress(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody AddDeliveryAddressRequest request
    ) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return deliveryAddressService.addDeliveryAddress(userId, request);
    }

    @PatchMapping("/me/addresses/{deliveryAddressId}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryAddressDto updateDeliveryAddress(
            @PathVariable("deliveryAddressId") UUID deliveryAddressId,
            @Valid @RequestBody UpdateDeliveryAddressRequest request
    ) {
        return deliveryAddressService.updateDeliveryAddress(deliveryAddressId, request);
    }

    @DeleteMapping("/me/addresses/{deliveryAddressId}")
    public void deleteUserDeliveryAddress(@PathVariable("deliveryAddressId") UUID deliveryAddressId) {
        deliveryAddressService.deleteDeliveryAddress(deliveryAddressId);
    }
}