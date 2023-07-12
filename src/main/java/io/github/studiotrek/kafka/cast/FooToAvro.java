//package io.github.studiotrek.kafka.cast;
//
//import io.github.studiotrek.kafka.data.Foo;
//import io.github.studiotrek.kafka.data.Product;
//import io.github.studiotrek.kafka.messaging.avro.FooDetailsAvro;
//import io.github.studiotrek.kafka.messaging.avro.ProductAvro;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FooToAvro {
//    public static FooDetailsAvro cast(final Foo foo) {
//        return FooDetailsAvro.newBuilder()
//                .setId(foo.getId())
//                .setName(foo.getName())
//                .setDescription(foo.getDescription())
//                .setProducts(productsAvro(foo.getProducts()))
//                .setDate(Timestamp.valueOf(foo.getDate()).getTime())
//                .build();
//    }
//
//    private static List<ProductAvro> productsAvro(final List<Product> products) {
//        final List<ProductAvro> list = new ArrayList<>();
//        products.forEach(value -> list.add(
//                ProductAvro.newBuilder()
//                        .setName(value.getName())
//                        .setValue(value.getValue())
//                        .build()
//        ));
//        return list;
//    }
//}