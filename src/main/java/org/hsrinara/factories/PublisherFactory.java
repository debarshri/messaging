package org.hsrinara.factories;

import org.hsrinara.GsonMarshaller;
import org.hsrinara.InMemoryBlockingPublisher;
import org.hsrinara.model.Publisher;

import java.util.concurrent.BlockingQueue;

public class PublisherFactory<T> {
    private final GsonMarshaller marshaller = new GsonMarshaller();
    private final BlockingQueue<T> blockingQueue;

    public PublisherFactory(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public Publisher<T> create() {
        return new InMemoryBlockingPublisher<>(blockingQueue);
    }
}
