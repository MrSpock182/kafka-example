package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.cast.FooToAvro;
import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.FooDetailsAvro;
import io.github.studiotrek.kafka.messaging.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class FooProducerWithKafka implements Producer<Foo> {
    private final String topic;
    private final KafkaTemplate<String, FooDetailsAvro> kafkaTemplate;

    public FooProducerWithKafka(
            @Value("${spring.kafka.topics.foo-details}") final String topic,
            final KafkaTemplate<String, FooDetailsAvro> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(final Foo value) {
        final FooDetailsAvro fooAvro = FooToAvro.cast(value);
        Message<FooDetailsAvro> build = MessageBuilder.withPayload(fooAvro)
                .setHeader("hash", fooAvro.hashCode())
                .setHeader("version", "2.0")
                .setHeader("user", "xpto")
                .setHeader("cid", value.getId())
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, value.getId())
                .build();
        kafkaTemplate.send(build)
                .addCallback(futureCallback());
    }

    private ListenableFutureCallback<SendResult<String, FooDetailsAvro>> futureCallback() {
        return new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(final SendResult<String, FooDetailsAvro> result) {
                System.out.println("Mensagem enviada");
            }
            @Override
            public void onFailure(final Throwable ex) {
                System.out.println("Envio com erro: " + ex);
            }
        };
    }
    //        kafkaTemplate.send(topic, partition, foo.getId(), fooAvro)
//                .addCallback(futureCallback());
}