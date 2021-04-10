package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessagingProducerWithKafka implements MessagingProducer<Foo> {

    private final String topic;
    private final KafkaTemplate<String, Foo> kafkaTemplate;

    public MessagingProducerWithKafka(
            @Value("${spring.kafka.topic.foo}") final String topic,
            final KafkaTemplate<String, Foo> kafkaTemplate
    ) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(final Foo foo) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), foo);
    }

}
