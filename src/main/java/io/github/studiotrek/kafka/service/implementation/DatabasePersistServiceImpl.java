package io.github.studiotrek.kafka.service.implementation;

import io.github.studiotrek.kafka.event.implementation.SummaryEvent;
import io.github.studiotrek.kafka.service.DatabasePersistService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class DatabasePersistServiceImpl implements DatabasePersistService {

    @Async
    @Override
    @EventListener
    public void persist(final SummaryEvent event) {
        System.out.println("Persiste na base de dados");
    }
}
