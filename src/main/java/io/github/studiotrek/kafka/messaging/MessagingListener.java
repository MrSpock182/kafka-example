package io.github.studiotrek.kafka.messaging;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface MessagingListener<T, I> {
    void listener(
            final T t,
            final ConsumerRecord<I, T> record
    );

    void retry(final T t);
}
