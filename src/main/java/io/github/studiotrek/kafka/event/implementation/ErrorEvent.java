package io.github.studiotrek.kafka.event.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.event.BaseEvent;

public class ErrorEvent extends BaseEvent<String, Foo> {
    public ErrorEvent(final Foo foo) {
        super(String.valueOf(foo.getId()), foo);
    }
}
