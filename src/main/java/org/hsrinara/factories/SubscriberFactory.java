package org.hsrinara.factories;

import org.hsrinara.InMemoryBlockingSubscriber;
import org.hsrinara.model.Subscriber;

import java.util.concurrent.BlockingQueue;

public class SubscriberFactory<T> {
    private final BlockingQueue<T> blockingQueue;

    public SubscriberFactory(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Subscriber<T> create() {
        return new InMemoryBlockingSubscriber<T>(blockingQueue);
    }
}
