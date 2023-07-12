//package io.github.studiotrek.kafka.cast;
//
//import io.github.studiotrek.kafka.data.Foo;
//import io.github.studiotrek.kafka.data.Product;
//import io.github.studiotrek.kafka.messaging.avro.FooDetailsAvro;
//import io.github.studiotrek.kafka.messaging.avro.ProductAvro;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class AvroToFoo {
//    public static Foo cast(final FooDetailsAvro fooDetails) {
//        final Timestamp timestamp = new Timestamp(fooDetails.getDate());
//        return new Foo(
//                fooDetails.getId().toString(),
//                fooDetails.getName().toString(),
//                fooDetails.getDescription().toString(),
//                products(fooDetails.getProducts()),
//                timestamp.toLocalDateTime());
//    }
//
//    private static List<Product> products(final List<ProductAvro> products) {
//        if (products == null) {
//            return Collections.emptyList();
//        }
//
//        final List<Product> list = new ArrayList<>();
//        products.forEach(value -> list.add(
//                new Product(value.getName().toString(), value.getValue())
//        ));
//        return list;
//    }
//
//}
