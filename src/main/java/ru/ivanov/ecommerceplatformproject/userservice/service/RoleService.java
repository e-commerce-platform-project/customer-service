package ru.ivanov.ecommerceplatformproject.userservice.service;

import ru.ivanov.ecommerceplatformproject.userservice.model.Role;

public interface RoleService {
    Role findByName(String name);
}
