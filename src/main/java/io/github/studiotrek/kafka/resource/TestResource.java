package io.github.studiotrek.kafka.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.messaging.MessagingListener;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    private final String topicRetry;
    private final ObjectMapper mapper;
    private final String bootstrapServers;
    private final MessagingProducer<Foo> producer;
    private final MessagingListener<ProducerRecord<String, Foo>, String> listener;

    public TestResource(
            @Value("${spring.kafka.topic.foo-retry}") String topicRetry,
            ObjectMapper mapper,
            @Value("${spring.kafka.bootstrap-servers}") String bootstrapServers,
            MessagingProducer<Foo> producer,
            MessagingListener<ProducerRecord<String, Foo>, String> listener) {
        this.topicRetry = topicRetry;
        this.mapper = mapper;
        this.bootstrapServers = bootstrapServers;
        this.producer = producer;
        this.listener = listener;
    }

    @GetMapping("/send")
    public void test() {
//        List<Foo> list = Arrays.asList(
//                new Foo("5", "RONALDO"),
//                new Foo("6", "CORINTHIANS"),
//                new Foo("7", "BRILHA"),
//                new Foo("8", "MUITO"),
//                new Foo("5", "RONALDO")
//        );
//        list.forEach(producer::send);

        producer.send(new Foo("1", "RONALDO"));

    }

    @GetMapping("/reprocess")
    public void reprocess() {

    }

}
