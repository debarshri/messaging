package org.hsrinara;

import org.hsrinara.factories.MessagingFactory;
import org.hsrinara.factories.PublisherFactory;
import org.hsrinara.factories.SubscriberFactory;
import org.hsrinara.model.Publisher;
import org.hsrinara.model.Subscriber;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BlockingMessageTest {

    private final Messaging<ByteBuffer> messaging = new MessagingFactory<ByteBuffer>().create();

    @Test
    public void send_single_byte_to_receiver() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(1);
        buffer.put((byte) 3);
        messaging.send(buffer);

        assertThat(messaging.readMessage(), comparesEqualTo(buffer));
    }

    @Test
    public void send_multiple_bytes_to_receiver() throws Exception {

        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put((byte) 3);
        buffer.put((byte) 6);
        messaging.send(buffer);

        assertThat(messaging.readMessage(), comparesEqualTo(buffer));
    }

    @Test
    public void read_more_than_is_available_returns_null() throws Exception {
        assertNull(messaging.readMessage());
    }
}
