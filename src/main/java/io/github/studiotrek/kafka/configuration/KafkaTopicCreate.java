//package io.github.studiotrek.kafka.configuration;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaTopicCreate {
//
//    @Bean
//    public NewTopic topicExample() {
//        return TopicBuilder
//                .name("foo")
//                .partitions(2)
//                .replicas(1)
//                .compact()
//                .configs(topicConfigs())
//                .build();
//    }
//
//    @Bean
//    public NewTopic topicRetryExample() {
//        return TopicBuilder
//                .name("foo_retry")
//                .partitions(1)
//                .replicas(1)
//                .compact()
//                .configs(topicConfigs())
//                .build();
//    }
//
//    private Map<String, String> topicConfigs() {
//        Map<String, String> map = new HashMap<>();
//        map.put("delete.retention.ms", "86500000");
//        map.put("file.delete.delay.ms", "86500000");
//        map.put("flush.messages", "86500000");
//        map.put("flush.ms", "86500000");
//        map.put("max.compaction.lag.ms", "86500000");
//        map.put("message.timestamp.difference.max.ms", "86500000");
//        map.put("retention.ms", "86500000");
//        map.put("segment.ms", "86500000");
//        map.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");
//        return map;
//    }
//}