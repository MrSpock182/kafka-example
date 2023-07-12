//package io.github.studiotrek.kafka.cast;
//
//import io.github.studiotrek.kafka.data.FooSummary;
//import io.github.studiotrek.kafka.repository.orm.FooSummaryOrm;
//
//public class SummaryToOrm {
//    public static FooSummaryOrm cast(final FooSummary summary) {
//        return new FooSummaryOrm(
//                summary.getId(),
//                summary.getName(),
//                summary.getDescription(),
//                summary.getProducts(),
//                summary.getDate()
//        );
//    }
//}
