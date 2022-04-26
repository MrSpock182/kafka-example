package io.github.studiotrek.kafka.cast;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.data.FooAvroV1;

public class AvroV1ToFoo {
    public static Foo cast(final FooAvroV1 foo) {
        return new Foo(
                foo.getId().toString(),
                foo.getName().toString(),
                "",
                null);
    }
}
