package org.hsrinara;

import org.hsrinara.model.Subscriber;

import java.util.concurrent.BlockingQueue;

public class InMemoryBlockingSubscriber<T> implements Subscriber<T> {

    private final BlockingQueue<T> blockingQueue;

    public InMemoryBlockingSubscriber(final BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public T readMessage() {
        return blockingQueue.poll();
    }
}
