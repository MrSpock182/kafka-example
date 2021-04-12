package io.github.studiotrek.kafka.configuration;

import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    public SeekToCurrentErrorHandler errorHandler(
            final KafkaTemplate<Object, Object> template
    ) {
        DeadLetterPublishingRecoverer recovery = new DeadLetterPublishingRecoverer(template,
                (consumerRecord, exception) -> new TopicPartition(
                        consumerRecord.topic().replace("_retry", "") + "_dead-letter",
                        0));
        return new SeekToCurrentErrorHandler(
                recovery,
                new FixedBackOff(1000, 3)
        );
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

}
