//package io.github.studiotrek.kafka.repository.orm;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
////@Document(collection = "foo-summary")
//@Entity
//@Table(name = "FooSummary")
//public class FooSummaryOrm {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private final String id;
//    private final String name;
//    private final String description;
//    private final Double products;
//    private final LocalDateTime date;
//
//    public FooSummaryOrm(
//            String id,
//            String name,
//            String description,
//            Double products,
//            LocalDateTime date) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.products = products;
//        this.date = date;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Double getProducts() {
//        return products;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//}