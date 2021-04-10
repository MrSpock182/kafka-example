package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingListener;
import io.github.studiotrek.kafka.messaging.MessagingRetry;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessagingListenerWithKafka implements MessagingListener<Foo, String> {

    private final MessagingRetry<Foo> retryProducer;

    public MessagingListenerWithKafka(final MessagingRetry<Foo> retryProducer) {
        this.retryProducer = retryProducer;
    }

    @Override
    @KafkaListener(topics = "${spring.kafka.topic.foo}", groupId = "${spring.kafka.group-id}")
    public void listener(
            @Payload final Foo foo,
            final ConsumerRecord<String, Foo> record
    ) {
        System.out.println("Received: " + foo.getName());
        if (foo.getName().startsWith("RONALDO")) {
            retryProducer.retry(record.topic(), foo);
        }
    }

    @Override
    @KafkaListener(topics = "${spring.kafka.topic.foo-retry}", groupId = "${spring.kafka.group-id}")
    public void retry(@Payload final Foo foo) {
        System.out.println("Received Retry: " + foo.getName());
        if (foo.getName().startsWith("RONALDO")) {
            throw new RuntimeException("failed");
        }
    }
}
