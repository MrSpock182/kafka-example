package io.github.studiotrek.kafka.messaging;

public interface MessagingProducer<T> {
    void send(T t);
}
