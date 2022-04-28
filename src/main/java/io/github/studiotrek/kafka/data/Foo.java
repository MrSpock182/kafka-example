package io.github.studiotrek.kafka.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Foo implements Serializable {
    private final String id;
    private final String name;
    private final String description;
    private final List<Product> products;
    private final LocalDateTime date;

    public Foo(
            String id,
            String name,
            String description,
            List<Product> products,
            LocalDateTime date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return Objects.equals(id, foo.id)
                && Objects.equals(name, foo.name)
                && Objects.equals(description, foo.description)
                && Objects.equals(products, foo.products)
                && Objects.equals(date, foo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, products, date);
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                ", date=" + date +
                '}';
    }
}