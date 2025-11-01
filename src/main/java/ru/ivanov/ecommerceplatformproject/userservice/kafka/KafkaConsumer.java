package ru.ivanov.ecommerceplatformproject.userservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.ivanov.ecommerceplatformproject.sharedlibs.event.UserRegisteredEvent;
import ru.ivanov.ecommerceplatformproject.userservice.service.UserService;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final UserService userService;

    @KafkaListener(topics = {"user-registered-event-topic"})
    public void handleUserRegisteredEvent(
            @Header("eventId") String eventId, //todo а надо ли??? думаю если делать идемпотентный консьюмер то надо ?
            @Payload UserRegisteredEvent event
    ) {
        userService.createUser(event);
    }
}