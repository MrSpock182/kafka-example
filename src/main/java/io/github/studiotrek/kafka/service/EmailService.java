package io.github.studiotrek.kafka.service;

import io.github.studiotrek.kafka.event.implementation.SummaryEvent;

public interface EmailService {
    void send(SummaryEvent event);
}
