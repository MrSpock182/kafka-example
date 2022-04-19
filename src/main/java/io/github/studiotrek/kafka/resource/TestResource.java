package io.github.studiotrek.kafka.resource;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestResource {

    private final MessagingProducer<Foo> producer;

    public TestResource(MessagingProducer<Foo> producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public void test() {
        producer.send(new Foo("1", "RONALDO", LocalDateTime.now()));
    }

}