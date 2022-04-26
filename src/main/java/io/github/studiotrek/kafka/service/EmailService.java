package io.github.studiotrek.kafka.service;

import io.github.studiotrek.kafka.event.implementation.ErrorEvent;

public interface EmailService {
    void send(ErrorEvent event);
}
