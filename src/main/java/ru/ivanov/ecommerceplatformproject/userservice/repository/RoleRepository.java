package ru.ivanov.ecommerceplatformproject.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivanov.ecommerceplatformproject.userservice.model.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}