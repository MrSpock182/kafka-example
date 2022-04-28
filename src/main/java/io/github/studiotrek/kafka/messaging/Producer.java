package io.github.studiotrek.kafka.messaging;

public interface Producer<T> {
    void sendMessage(T value);
}
