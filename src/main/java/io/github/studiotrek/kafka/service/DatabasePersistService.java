package io.github.studiotrek.kafka.service;

import io.github.studiotrek.kafka.event.implementation.ErrorEvent;

public interface DatabasePersistService {
    void persist(ErrorEvent event);
}
