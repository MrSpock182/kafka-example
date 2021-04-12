package io.github.studiotrek.kafka.messaging;

public interface MessagingRetry<T> {
    void sendRetry(String topic, T t);
}
