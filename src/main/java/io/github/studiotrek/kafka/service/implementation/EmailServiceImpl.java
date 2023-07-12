package io.github.studiotrek.kafka.service.implementation;

import io.github.studiotrek.kafka.event.implementation.SummaryEvent;
import io.github.studiotrek.kafka.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Async
    @Override
    @EventListener
    public void send(final SummaryEvent event) {
        System.out.println("Envia email");
    }
}
