package io.github.studiotrek.kafka.service;

import io.github.studiotrek.kafka.event.implementation.SummaryEvent;

public interface DatabasePersistService {
    void persist(SummaryEvent event);
}
