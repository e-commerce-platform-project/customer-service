package ru.ivanov.ecommerceplatformproject.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivanov.ecommerceplatformproject.userservice.entity.Address;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
