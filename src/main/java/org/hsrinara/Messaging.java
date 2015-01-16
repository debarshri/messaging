package org.hsrinara;

import org.hsrinara.model.Publisher;
import org.hsrinara.model.Subscriber;

public class Messaging<T> {

    private final Publisher<T> publisher;
    private final Subscriber<T> subscriber;

    public Messaging(final Publisher<T> publisher, final Subscriber<T> subscriber) {
        this.publisher = publisher;
        this.subscriber = subscriber;
    }

    public void send(T message) {
        publisher.send(message);
    }

    public T readMessage() {
        return subscriber.readMessage();
    }
}
