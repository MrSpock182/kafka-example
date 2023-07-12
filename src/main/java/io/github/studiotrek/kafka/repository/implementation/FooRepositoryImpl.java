//package io.github.studiotrek.kafka.repository.implementation;
//
//import io.github.studiotrek.kafka.repository.FooRepository;
//import io.github.studiotrek.kafka.repository.orm.FooSummaryOrm;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FooRepositoryImpl implements FooRepository {
//
//    private final FooRepositoryWithMySql repository;
//
//    public FooRepositoryImpl(FooRepositoryWithMySql repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public FooSummaryOrm insert(final FooSummaryOrm orm) {
//        return repository.save(orm);
//        return null;
//    }
//}
