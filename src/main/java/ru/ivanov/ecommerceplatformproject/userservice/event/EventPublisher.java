package ru.ivanov.ecommerceplatformproject.userservice.event;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.ivanov.ecommerceplatformproject.sharedlibs.event.UserCreatedEvent;

@Component
@RequiredArgsConstructor
public class EventPublisher {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendUserCreatedEventToKafka(UserCreatedEvent event) {
        //todo
        kafkaTemplate.send("user-created-event-topic", event);
    }
}