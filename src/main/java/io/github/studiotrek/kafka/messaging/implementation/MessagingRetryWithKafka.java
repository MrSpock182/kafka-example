package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.messaging.MessagingRetry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessagingRetryWithKafka<T> implements MessagingRetry<T> {
    private final KafkaTemplate<String, T> kafkaTemplate;

    public MessagingRetryWithKafka(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendRetry(String topic, T t) {
        kafkaTemplate.send(topic + "_retry", UUID.randomUUID().toString(), t);
    }
}
