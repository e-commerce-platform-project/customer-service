package ru.ivanov.ecommerceplatformproject.userservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.ivanov.ecommerceplatformproject.sharedlibs.event.UserRegisteredEvent;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

@Component
@RequiredArgsConstructor
public class UserEventConsumer {

    private final UserService userService;

    @KafkaListener(topics = {"user-registered-event-topic"})
    public void handleUserRegisteredEvent(@Payload UserRegisteredEvent event) {
        userService.addUser(event);
    }
}