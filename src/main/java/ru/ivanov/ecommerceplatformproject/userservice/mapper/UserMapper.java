package ru.ivanov.ecommerceplatformproject.userservice.mapper;

import org.springframework.stereotype.Component;
import ru.ivanov.ecommerceplatformproject.common.dto.UserDto;
import ru.ivanov.ecommerceplatformproject.userservice.model.Role;
import ru.ivanov.ecommerceplatformproject.userservice.model.User;


@Component
public class UserMapper {

    public UserDto toDto(User User) {
        return new UserDto(
          User.getId(),
          User.getFirstName(),
          User.getLastName(),
          User.getEmail(),
          User.getRoles().stream()
                  .map(Role::getName)
                  .toList()
        );
    }
}
