package org.hsrinara.demo;

import org.hsrinara.factories.PublisherFactory;
import org.hsrinara.factories.SubscriberFactory;
import org.hsrinara.model.Publisher;
import org.hsrinara.model.Subscriber;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class OnePubOneSubMain {
    public static void main(String[] args) throws Exception {

        final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(100);
        final Publisher<String> publisher = new PublisherFactory<>(blockingQueue).create();
        final Subscriber<String> subscriber = new SubscriberFactory<>(blockingQueue).create();
        final Thread publisherThread = new Thread(() -> {
            while (true) {
                publisher.send("hello");
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100));
            }
        });

        final Thread subscribingThread = new Thread(() -> {
            while (true) {
                System.out.println(subscriber.readMessage());
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(400));
            }
        });

        publisherThread.start();
        subscribingThread.start();

    }
}
