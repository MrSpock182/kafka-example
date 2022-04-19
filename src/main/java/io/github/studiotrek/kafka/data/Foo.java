package io.github.studiotrek.kafka.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Foo implements Serializable {
    private final String id;
    private final String name;
    private final LocalDateTime date;

    public Foo(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("date") LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }
}