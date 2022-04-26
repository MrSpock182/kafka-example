package io.github.studiotrek.kafka.cast;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.FooAvroV2;

import java.sql.Timestamp;

public class FooToAvroV2 {
    public static FooAvroV2 cast(final Foo foo) {
        return FooAvroV2.newBuilder()
                .setId(foo.getId())
                .setName(foo.getName())
                .setDescription(foo.getDescription())
                .setDate(Timestamp.valueOf(foo.getDate()).getTime())
                .build();
    }
}
