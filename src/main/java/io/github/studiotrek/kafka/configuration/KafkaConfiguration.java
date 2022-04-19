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
    public SeekToCurrentErrorHandler errorHandler(final KafkaTemplate<Object, Object> template) {
        return new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(template, (consumerRecord, exception) ->
                        new TopicPartition(
                                consumerRecord.topic().replace("_retry", "") + "_dead-letter",
                                consumerRecord.partition()
                        )
                ),
                new FixedBackOff(computeInterval(), 4));
    }

    private long computeInterval() {
        return 2 * 60 * 60 * 1000L;
    }

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    }

}