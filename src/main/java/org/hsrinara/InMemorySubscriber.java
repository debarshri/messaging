package org.hsrinara;

public class InMemorySubscriber implements Subscriber {
    @Override
    public byte[] readMessage() {
        return new byte[0];
    }
}
