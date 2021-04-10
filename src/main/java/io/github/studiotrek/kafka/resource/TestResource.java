package io.github.studiotrek.kafka.resource;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestResource {

    private final MessagingProducer<Foo> producer;

    public TestResource(MessagingProducer<Foo> producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public void test() {
        List<Foo> list = Arrays.asList(
                new Foo("RONALDO"),
                new Foo("CORINTHIANS"),
                new Foo("BRILHA"),
                new Foo("MUITO"),
                new Foo("RONALDO"));
        list.forEach(producer::send);
    }

}
