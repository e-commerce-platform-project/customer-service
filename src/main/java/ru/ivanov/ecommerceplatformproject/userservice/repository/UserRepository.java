package ru.ivanov.ecommerceplatformproject.userservice.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import ru.ivanov.ecommerceplatformproject.userservice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String username);

    @EntityGraph("UserWithAddresses")
    Optional<User> findUserById(UUID id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<User> findUserAndLockById(UUID userId);
}