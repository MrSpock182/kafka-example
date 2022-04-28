package io.github.studiotrek.kafka.resource;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.Product;
import io.github.studiotrek.kafka.messaging.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class TestResource {
    private final Producer<Foo> producer;

    public TestResource(Producer<Foo> producer) {
        this.producer = producer;
    }

    @ResponseStatus(OK)
    @GetMapping("/v1/send/{name}")
    public void test(
            @PathVariable final String name) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Caixa Um", 12.3));
        products.add(new Product("Caixa Dois", 15.6));
        products.add(new Product("Caixa Tres", 17.2));
        producer.sendMessage(
                new Foo("1", name, "description", products, LocalDateTime.now())
        );
    }
}