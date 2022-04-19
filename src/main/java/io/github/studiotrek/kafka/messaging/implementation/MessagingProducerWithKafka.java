package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagingProducerWithKafka implements MessagingProducer<Foo> {
    private final String topic;
    private final KafkaTemplate<String, Foo> kafkaTemplate;

    public MessagingProducerWithKafka(
            @Value("${spring.kafka.topic.foo}") final String topic,
            final KafkaTemplate<String, Foo> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(final Foo foo) {
        ProducerRecord<String, Foo> producerRecord = new ProducerRecord<>(topic, foo.getId(), foo);
        producerRecord.headers().add(new RecordHeader("user", "xpto".getBytes()));
        kafkaTemplate.send(producerRecord);
    }
}