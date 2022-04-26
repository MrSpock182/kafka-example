package io.github.studiotrek.kafka.messaging;

public interface MessagingProducer<T> {
    void sendV1(T t, Integer partition);

    void sendV2(T t, Integer partition);
}
