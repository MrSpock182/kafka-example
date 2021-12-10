package io.github.studiotrek.kafka.data;

import java.io.Serializable;
import java.util.Objects;

public class Foo implements Serializable {
    private String id;
    private String name;

    public Foo() {
    }

    public Foo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return Objects.equals(id, foo.id) && Objects.equals(name, foo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
