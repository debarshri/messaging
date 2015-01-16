package org.hsrinara;

import org.hsrinara.model.Publisher;

import java.util.concurrent.BlockingQueue;

public class InMemoryBlockingPublisher<T> implements Publisher<T> {

    private final BlockingQueue<T> blockingQueue;

    public InMemoryBlockingPublisher(final BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void send(T message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            throw new RuntimeException("interrupted " + e);
        }
    }
}
