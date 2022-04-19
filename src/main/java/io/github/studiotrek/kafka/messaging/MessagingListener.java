package io.github.studiotrek.kafka.messaging;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface MessagingListener<T, I> {
    void listener(
            String user,
            T t,
            ConsumerRecord<I, T> consumerRecord
    );

    void retry(String user, T t);
}
