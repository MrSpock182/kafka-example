package io.github.studiotrek.kafka.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonMapper {

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }

}
