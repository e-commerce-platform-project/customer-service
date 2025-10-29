package ru.ivanov.ecommerceplatformproject.userservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.request.LoginRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UserRegistrationRequest;
import ru.ivanov.ecommerceplatformproject.userservice.exception.UserNotFoundException;
import ru.ivanov.ecommerceplatformproject.userservice.exception.UsernameIsTakenException;
import ru.ivanov.ecommerceplatformproject.userservice.keycloak.KeycloakDataMapper;
import ru.ivanov.ecommerceplatformproject.userservice.mapper.UserMapper;
import ru.ivanov.ecommerceplatformproject.userservice.entity.User;
import ru.ivanov.ecommerceplatformproject.userservice.repository.UserRepository;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static ru.ivanov.ecommerceplatformproject.userservice.util.MessageUtils.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Lazy
    @Autowired
    private UserService self;

    private final UserRepository userRepository;
//    private final RoleService roleService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;



    @Override
    @Transactional(readOnly = true)
    public UserDto verifyCredentials(String username, String password) {
        User user = findUserByUsername(username);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials");
        }

        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(UUID userId) {
        User user = findUserById(userId);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserDto updateUserPatch(UUID userId, UpdateUserRequest request) {
        User user = findUserById(userId);

        if (request.email() != null) {
            if (existsByUsername(request.email())) {
                throw new UsernameIsTakenException(EMAIL_IS_ALREADY_TAKEN.formatted(request.email()));
            }

            user.setEmail(request.email());
        }

        if (request.firstName() != null) {
            user.setFirstName(request.firstName());
        }

        if (request.lastName() != null) {
            user.setLastName(request.lastName());
        }

        if (request.password() != null) {
            user.setPassword(passwordEncoder.encode(request.password()));
        }

        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }


    @Override
    @Transactional
    public void deleteUserById(UUID userId) {
        User user = findUserById(userId);
        userRepository.deleteById(userId);

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(
                "user-deleted-event-topic",
                null,
                new UserDeletedEvent(userId)
        );

        future.whenComplete((result, exception) -> {
            if (exception != null) {
                System.out.println("Failed to send message " + exception.getMessage());
            } else {
                System.out.println("Message sent successfully, " + result.getRecordMetadata().toString());
            }
        });
    }


    private User findUserById(UUID userId) {
        return  userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND.formatted(userId)));
    }

    private User findUserByUsername(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_WITH_EMAIL.formatted(email)));
    }

    private boolean existsByUsername(String email) {
        return userRepository.existsByEmail(email);
    }
}