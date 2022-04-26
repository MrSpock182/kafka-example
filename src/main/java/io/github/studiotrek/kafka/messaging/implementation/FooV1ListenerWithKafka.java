//package io.github.studiotrek.kafka.messaging.implementation;
//
//import io.github.studiotrek.kafka.cast.AvroV1ToFoo;
//import io.github.studiotrek.kafka.data.FooAvroV1;
//import io.github.studiotrek.kafka.service.ErrorService;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.RetryableTopic;
//import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.retry.annotation.Backoff;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//public class FooV1ListenerWithKafka {
//
//    private final ErrorService errorService;
//
//    public FooV1ListenerWithKafka(ErrorService errorService) {
//        this.errorService = errorService;
//    }
//
//    @RetryableTopic(
//            autoCreateTopics = "false",
//            backoff = @Backoff(delay = 15000, multiplier = 2.0),
//            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)
//    @KafkaListener(
//            topics = "${spring.kafka.topic.foo}",
//            groupId = "${spring.kafka.group-id}",
//            containerFactory = "filterFactory"
//    )
//    public void listener(
//            final @Header("hash") String hash,
//            final @Header("version") String version,
//            final @Header("user") String user,
//            final @Header("cid") String cid,
//            final @Payload ConsumerRecord<String, FooAvroV1> consumerRecord) {
//        System.out.println(
//                " hash: " + hash +
//                " version: " + version +
//                " user: " + user +
//                " cid: " + cid +
//                " key: " + consumerRecord.key() +
//                " value: " + consumerRecord.value() +
//                " time: " + LocalDateTime.now()
//        );
//        errorService.error(AvroV1ToFoo.cast(consumerRecord.value()));
//    }
//
//    @KafkaListener(
//            topics = "foo-dlt",
//            groupId = "foo-group"
//    )
//    public void dltListen(
//            final @Header("hash") String hash,
//            final @Header("version") String version,
//            final @Header("user") String user,
//            final @Header("cid") String cid,
//            final @Payload ConsumerRecord<String, FooAvroV1> consumerRecord) {
//        System.out.println("Error ao executar: " + consumerRecord.value());
//    }
//}