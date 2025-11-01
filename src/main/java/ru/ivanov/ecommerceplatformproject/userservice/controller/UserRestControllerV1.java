package ru.ivanov.ecommerceplatformproject.userservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.security.JwtPrincipalDetails;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestControllerV1 {

    private final UserService userService;

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser() {
        UUID userId = null; //todo получение из токена
        return userService.getUser(userId);
    }

    @PatchMapping
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
}
