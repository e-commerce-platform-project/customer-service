package ru.ivanov.ecommerceplatformproject.userservice.service.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.ecommerceplatformproject.sharedlibs.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.sharedlibs.event.UserRegisteredEvent;
import ru.ivanov.ecommerceplatformproject.userservice.dto.request.UpdateUserRequest;
import ru.ivanov.ecommerceplatformproject.userservice.entity.User;
import ru.ivanov.ecommerceplatformproject.userservice.exception.UserNotFoundException;
import ru.ivanov.ecommerceplatformproject.userservice.exception.UsernameIsTakenException;
import ru.ivanov.ecommerceplatformproject.userservice.mapper.UserMapper;
import ru.ivanov.ecommerceplatformproject.userservice.repository.UserRepository;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

import java.util.UUID;

import static ru.ivanov.ecommerceplatformproject.userservice.util.MessageUtils.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final EntityManager entityManager;
    private final UserRepository userRepository;


    @Override
    @Transactional
    public void createUser(UserRegisteredEvent event) {
        if (userRepository.existsByEmail(event.email())) {
            throw new UsernameIsTakenException(""); //todo надо ли
        }

        User user = userMapper.toEntity(event);
        entityManager.persist(user);
    }

    @Override
    public UserDto getUser(UUID userId) {
        User user = getUserByIdOrThrow(userId);
//        return userMapper.toDto(user);
        return null;
    }

    @Override
    @Transactional
    //todo это точно должно быть через keycloak сначала поэтому сейчас это неправильно
    public UserDto updateUserPatch(UUID userId, UpdateUserRequest request) {
        User user = getUserAndLockByIdOrThrow(userId);

        if (request.email() != null) {
            if (userRepository.existsByEmail(request.email())) {
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

        User savedUser = userRepository.save(user);
//        return userMapper.toDto(savedUser);
        return null;
    }

    private User getUserByIdOrThrow(UUID userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND.formatted(userId)));
    }

    private User getUserAndLockByIdOrThrow(UUID userId) {
        return userRepository.getUserAndLockById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found"));//todo
    }
}