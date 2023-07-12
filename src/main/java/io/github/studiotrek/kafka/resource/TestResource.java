package io.github.studiotrek.kafka.resource;

import io.github.studiotrek.kafka.messaging.EnrichmentCnpjProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class TestResource {

    private final EnrichmentCnpjProducer producer;

    public TestResource(EnrichmentCnpjProducer producer) {
        this.producer = producer;
    }

    @ResponseStatus(OK)
    @GetMapping("/v1/send/{name}")
    public void test(@PathVariable final String name) throws IOException {
        List<String> list = readAllLines(Paths.get("src/main/resources/cnpj.txt"));
        list.parallelStream().forEach(producer::producer);
    }
}