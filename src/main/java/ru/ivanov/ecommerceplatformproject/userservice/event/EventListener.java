package ru.ivanov.ecommerceplatformproject.userservice.event;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.ivanov.ecommerceplatformproject.userservice.repository.UserRepository;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

@Component
@RequiredArgsConstructor
public class EventListener {
    private final UserService userService;
    private final UserRepository userRepository;//todo надо что-то одно ???


    @KafkaListener(topics = {"keycloakUser-created-event-topic"})
    public void handleKeycloakUserCreatedEventTopic() {
        //todo сохранение юзера в бд
    }
}