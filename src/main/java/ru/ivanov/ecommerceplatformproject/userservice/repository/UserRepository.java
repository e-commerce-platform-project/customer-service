package ru.ivanov.ecommerceplatformproject.userservice.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.history.RevisionRepository;
import ru.ivanov.ecommerceplatformproject.userservice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserById(UUID id);

    boolean existsByEmail(String username);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<User> getUserAndLockById(UUID userId);
}