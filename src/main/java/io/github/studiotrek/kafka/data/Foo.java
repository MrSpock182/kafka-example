package io.github.studiotrek.kafka.data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Foo implements Serializable {
    private final String id;
    private final String name;
    private final String description;
    private final LocalDateTime date;

    public Foo(String id, String name, String description, LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
