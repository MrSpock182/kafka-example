package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.messaging.MessagingRetry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagingRetryWithKafka<T> implements MessagingRetry<T> {
    private final KafkaTemplate<String, T> kafkaTemplate;

    public MessagingRetryWithKafka(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendRetry(String topic, String id, T t) {
        kafkaTemplate.send(topic + "_retry", id, t);
    }
}
