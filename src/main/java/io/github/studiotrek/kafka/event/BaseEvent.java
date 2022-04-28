package io.github.studiotrek.kafka.event;

public abstract class BaseEvent<I, V> {
    private final I id;
    private final V value;

    protected BaseEvent(I id, V value) {
        this.id = id;
        this.value = value;
    }

    public I getId() {
        return id;
    }

    public V getValue() {
        return value;
    }
}
