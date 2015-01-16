package org.hsrinara.factories;

import org.hsrinara.Messaging;
import org.hsrinara.model.Publisher;
import org.hsrinara.model.Subscriber;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MessagingFactory<T> {

    public Messaging<T> create() {
        final BlockingQueue<T> blockingQueue = new ArrayBlockingQueue<>(100);
        final Publisher<T> publisher = new PublisherFactory<>(blockingQueue).create();
        final Subscriber<T> subscriber = new SubscriberFactory<>(blockingQueue).create();
        return new Messaging<>(publisher, subscriber);
    }
}
