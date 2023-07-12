package io.github.studiotrek.kafka.messaging;

import br.com.avro.EnrichmentAvro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class EnrichmentCnpjProducer {
    private final String topic;
    private final KafkaTemplate<String, EnrichmentAvro> kafkaTemplate;

    public EnrichmentCnpjProducer(
            @Value("${spring.kafka.topics.request-enrichment-receita}") String topic,
            KafkaTemplate<String, EnrichmentAvro> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void producer(final String cnpj) {
        EnrichmentAvro enrichment = EnrichmentAvro.newBuilder().setCnpj(cnpj).build();
        Message<EnrichmentAvro> message = MessageBuilder.withPayload(enrichment)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, cnpj)
                .build();
        kafkaTemplate.send(message)
                .addCallback(futureCallback());
    }

    private ListenableFutureCallback<SendResult<String, EnrichmentAvro>> futureCallback() {
        return new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Erro ao enviar mensagem para o kafka");
            }

            @Override
            public void onSuccess(SendResult<String, EnrichmentAvro> result) {
                System.out.println("Sucesso ao enviar mensagem ao kafka");
            }
        };
    }

}
