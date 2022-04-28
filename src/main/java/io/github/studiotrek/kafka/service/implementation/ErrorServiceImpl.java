package io.github.studiotrek.kafka.service.implementation;

import io.github.studiotrek.kafka.data.Foo;
import io.github.studiotrek.kafka.event.implementation.ErrorEvent;
import io.github.studiotrek.kafka.service.ErrorService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {
    private final ApplicationEventPublisher publisher;

    public ErrorServiceImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void error(final Foo foo) {
        if (foo.getName().equals("Ronaldo")) {
            throw new RuntimeException();
        }
        publisher.publishEvent(new ErrorEvent(foo));
    }
}
