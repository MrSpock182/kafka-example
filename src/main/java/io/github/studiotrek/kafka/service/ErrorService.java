package io.github.studiotrek.kafka.service;

import io.github.studiotrek.kafka.data.FooSummary;

public interface ErrorService {
    void error(FooSummary foo);
}
