package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingListener;
import io.github.studiotrek.kafka.messaging.MessagingRetry;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessagingListenerWithKafka implements MessagingListener<Foo, String> {

    private final MessagingRetry<Foo> retryProducer;

    public MessagingListenerWithKafka(final MessagingRetry<Foo> retryProducer) {
        this.retryProducer = retryProducer;
    }

    @Override
    @KafkaListener(
            topics = "${spring.kafka.topic.foo}",
            groupId = "${spring.kafka.group-id}")
    public void listener(
            final @Header("user") String user,
            final @Payload Foo payload,
            final ConsumerRecord<String, Foo> consumerRecord) {
        System.out.println("TEST");
    }

    @Override
    @KafkaListener(
            id = "${spring.kafka.topic.foo-retry}",
            topics = "${spring.kafka.topic.foo-retry}",
            groupId = "${spring.kafka.group-id}")
    public void retry(
            final @Header("user") String user,
            final @Payload Foo payload) {
        System.out.println("TEST");
    }

}
