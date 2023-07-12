//package io.github.studiotrek.kafka.cast;
//
//import io.github.studiotrek.kafka.data.*;
//import io.github.studiotrek.kafka.messaging.avro.FooSummaryAvro;
//
//import java.sql.Timestamp;
//
//public class AvroToSummary {
//    public static FooSummary cast(final FooSummaryAvro summary) {
//        final Timestamp timestamp = new Timestamp(summary.getDate());
//        return new FooSummary(
//                summary.getId().toString(),
//                summary.getName().toString(),
//                summary.getDescription().toString(),
//                summary.getProducts(),
//                timestamp.toLocalDateTime()
//        );
//    }
//}