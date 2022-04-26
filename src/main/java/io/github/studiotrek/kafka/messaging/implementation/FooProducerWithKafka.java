package io.github.studiotrek.kafka.messaging.implementation;

import io.github.studiotrek.kafka.cast.FooToAvroV1;
import io.github.studiotrek.kafka.cast.FooToAvroV2;
import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.FooAvroV1;
import io.github.studiotrek.kafka.data.FooAvroV2;
import io.github.studiotrek.kafka.messaging.MessagingProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class FooProducerWithKafka implements MessagingProducer<Foo> {
    private final String topic;
    private final KafkaTemplate<String, FooAvroV1> kafkaTemplateV1;
    private final KafkaTemplate<String, FooAvroV2> kafkaTemplateV2;

    public FooProducerWithKafka(
            @Value("${spring.kafka.topic.foo}") final String topic,
            final KafkaTemplate<String, FooAvroV1> kafkaTemplateV1,
            final KafkaTemplate<String, FooAvroV2> kafkaTemplateV2) {
        this.topic = topic;
        this.kafkaTemplateV1 = kafkaTemplateV1;
        this.kafkaTemplateV2 = kafkaTemplateV2;
    }

    @Override
    public void sendV1(final Foo foo, final Integer partition) {
        final FooAvroV1 fooAvro = FooToAvroV1.cast(foo);
        Message<FooAvroV1> build = MessageBuilder.withPayload(fooAvro)
                .setHeader("hash", fooAvro.hashCode())
                .setHeader("version", "1.0")
                .setHeader("user", "xpto")
                .setHeader("cid", foo.getId())
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, foo.getId())
                .build();

//        kafkaTemplate.send(topic, partition, foo.getId(), fooAvro)
//                .addCallback(futureCallback());

        kafkaTemplateV1.send(build)
                .addCallback(futureCallbackV1());
    }

    @Override
    public void sendV2(final Foo foo, final Integer partition) {
        final FooAvroV2 fooAvro = FooToAvroV2.cast(foo);
        Message<FooAvroV2> build = MessageBuilder.withPayload(fooAvro)
                .setHeader("hash", fooAvro.hashCode())
                .setHeader("version", "2.0")
                .setHeader("user", "xpto")
                .setHeader("cid", foo.getId())
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, foo.getId())
                .build();

//        kafkaTemplate.send(topic, partition, foo.getId(), fooAvro)
//                .addCallback(futureCallback());

        kafkaTemplateV2.send(build)
                .addCallback(futureCallbackV2());
    }

    private ListenableFutureCallback<SendResult<String, FooAvroV1>> futureCallbackV1() {
        return new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(final SendResult<String, FooAvroV1> result) {
                System.out.println("Mensagem enviada");
            }

            @Override
            public void onFailure(final Throwable ex) {
                System.out.println("Envio com erro: " + ex);
            }
        };
    }

    private ListenableFutureCallback<SendResult<String, FooAvroV2>> futureCallbackV2() {
        return new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(final SendResult<String, FooAvroV2> result) {
                System.out.println("Mensagem enviada");
            }

            @Override
            public void onFailure(final Throwable ex) {
                System.out.println("Envio com erro: " + ex);
            }
        };
    }
}