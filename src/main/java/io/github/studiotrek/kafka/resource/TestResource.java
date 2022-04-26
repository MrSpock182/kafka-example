package io.github.studiotrek.kafka.resource;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class TestResource {

    private final MessagingProducer<Foo> producer;

    public TestResource(MessagingProducer<Foo> producer) {
        this.producer = producer;
    }

    @ResponseStatus(OK)
    @GetMapping("/v1/send/{name}/{partition}")
    public void test(
            @PathVariable final String name,
            @PathVariable final Integer partition) {
        producer.sendV1(new Foo("1", name, "description", LocalDateTime.now()), partition);
    }
}