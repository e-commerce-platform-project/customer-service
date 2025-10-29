package ru.ivanov.ecommerceplatformproject.userservice.service;

import ru.ivanov.ecommerceplatformproject.userservice.entity.Role;

public interface RoleService {
    Role findByName(String name);
}
