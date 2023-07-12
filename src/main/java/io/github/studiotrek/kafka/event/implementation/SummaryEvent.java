package io.github.studiotrek.kafka.event.implementation;

import io.github.studiotrek.kafka.data.FooSummary;
import io.github.studiotrek.kafka.event.BaseEvent;

public class SummaryEvent extends BaseEvent<String, FooSummary> {
    public SummaryEvent(final FooSummary foo) {
        super(String.valueOf(foo.getId()), foo);
    }
}
