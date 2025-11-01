package ru.ivanov.ecommerceplatformproject.userservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.ivanov.ecommerceplatformproject.sharedlibs.event.UserRegisteredEvent;
import ru.ivanov.ecommerceplatformproject.userservice.entity.User;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;


@Component
@Mapper(componentModel = SPRING)
public interface UserMapper {

    @Mapping(target = "id", source = "event.userId") //todo
    User toEntity(UserRegisteredEvent event);
}