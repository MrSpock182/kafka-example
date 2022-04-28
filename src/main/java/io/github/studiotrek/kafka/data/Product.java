package io.github.studiotrek.kafka.data;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private final String name;
    private final Double value;

    public Product(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(value, product.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
