package org.hsrinara.factories;

import org.hsrinara.InMemoryBlockingPublisher;
import org.hsrinara.model.Publisher;

import java.util.concurrent.BlockingQueue;

public class PublisherFactory<T> {
    private final BlockingQueue<T> blockingQueue;

    public PublisherFactory(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Publisher<T> create() {
        return new InMemoryBlockingPublisher<>(blockingQueue);
    }
}
