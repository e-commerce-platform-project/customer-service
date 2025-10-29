package ru.ivanov.ecommerceplatformproject.userservice.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivanov.ecommerceplatformproject.userservice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @EntityGraph(attributePaths = "roles")
    Optional<User> findUserByEmail(String username);

    @EntityGraph(attributePaths = "roles")
    Optional<User> findUserById(UUID id);

    boolean existsByEmail(String username);
}