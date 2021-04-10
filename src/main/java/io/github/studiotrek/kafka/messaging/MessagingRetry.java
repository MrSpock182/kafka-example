package io.github.studiotrek.kafka.messaging;

public interface MessagingRetry<T> {
    void retry(String topic, T t);
}
