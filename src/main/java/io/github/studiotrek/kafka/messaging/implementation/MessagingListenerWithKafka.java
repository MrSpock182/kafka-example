package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingListener;
import io.github.studiotrek.kafka.messaging.MessagingRetry;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessagingListenerWithKafka implements MessagingListener<ProducerRecord<String, Foo>, String> {

    private final MessagingRetry<Foo> retryProducer;

    public MessagingListenerWithKafka(final MessagingRetry<Foo> retryProducer) {
        this.retryProducer = retryProducer;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.foo}",
            groupId = "${spring.kafka.group-id}")
    public void listener(
            final @Header("user") String user,
            final @Payload Foo stringFooProducerRecord,
            final ConsumerRecord<String, Foo> consumerRecord) {
        System.out.println("TEST");
    }

//    @Override
//    @KafkaListener(
//            id = "${spring.kafka.topic.foo-retry}",
//            topics = "${spring.kafka.topic.foo-retry}",
//            groupId = "${spring.kafka.group-id}")
//    public void retry(final ProducerRecord<String, Foo> stringFooProducerRecord) {
//        System.out.println("TEST");
//    }

    //    @Override
//    @KafkaListener(
//            id = "${spring.kafka.topic.foo}",
//            topics = "${spring.kafka.topic.foo}",
//            groupId = "${spring.kafka.group-id}")
//    public void listener(@Payload final Foo foo, final ConsumerRecord<String, Foo> consumerRecord) {
//        System.out.println("Received: " + foo.getName());
//        if (foo.getName().startsWith("RONALDO")) {
//            retryProducer.sendRetry(consumerRecord.topic(), foo.getId(), foo);
//        }
//    }
//
//    @Override
//    @KafkaListener(
//            id = "${spring.kafka.topic.foo-retry}",
//            topics = "${spring.kafka.topic.foo-retry}",
//            groupId = "${spring.kafka.group-id}")
//    public void retry(@Payload final Foo foo) {
//        System.out.println("Received Retry: " + foo.getName());
//        if (foo.getName().startsWith("RONALDO")) {
//            throw new RuntimeException("failed");
//        }
//    }

}
