package io.github.studiotrek.kafka.cast;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.FooAvroV2;

import java.sql.Timestamp;

public class AvroV2ToFoo {
    public static Foo cast(final FooAvroV2 foo) {
        final Timestamp timestamp = new Timestamp(foo.getDate());
        return new Foo(
                foo.getId().toString(),
                foo.getName().toString(),
                foo.getDescription().toString(),
                timestamp.toLocalDateTime());
    }
}
