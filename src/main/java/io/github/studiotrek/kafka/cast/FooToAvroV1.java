package io.github.studiotrek.kafka.cast;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.FooAvroV1;

public class FooToAvroV1 {
    public static FooAvroV1 cast(final Foo foo) {
        return FooAvroV1.newBuilder()
                .setId(foo.getId())
                .setName(foo.getName())
                .build();
    }
}
