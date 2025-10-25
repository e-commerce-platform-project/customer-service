package ru.ivanov.ecommerceplatformproject.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.ecommerceplatformproject.common.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.common.dto.request.LoginRequest;
import ru.ivanov.ecommerceplatformproject.common.dto.request.UserRegistrationRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.security.JwtPrincipalDetails;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('AUTH_SERVICE')")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRegistrationRequest request) {
        UserDto createdUser = userService.createUser(request);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/verify-credentials")
    @PreAuthorize("hasRole('AUTH_SERVICE')")
    public ResponseEntity<UserDto> verifyCredentials(@Valid @RequestBody LoginRequest request) {
        UserDto userDto = userService.verifyCredentials(request.email(), request.password());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('AUTH_SERVICE')")
    public ResponseEntity<UserDto> getUser(@AuthenticationPrincipal JwtPrincipalDetails principalDetails) {
        UUID userId = principalDetails.getPrincipalId();
        UserDto user = userService.getUser(userId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(user);
    }

    @PatchMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserDto> updateUserPatch(
           @Valid @RequestBody UpdateUserRequest request,
           @AuthenticationPrincipal JwtPrincipalDetails principalDetails
    ) {
        UUID userId = principalDetails.getPrincipalId();
        UserDto updatedUser = userService.updateUserPatch(userId, request);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatedUser);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> deleteUser(
            @AuthenticationPrincipal JwtPrincipalDetails principalDetails
    ) {
        UUID userId = principalDetails.getPrincipalId();
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
