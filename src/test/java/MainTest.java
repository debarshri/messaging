import org.hsrinara.InMemoryPublisher;
import org.hsrinara.InMemorySubscriber;
import org.hsrinara.Publisher;
import org.hsrinara.Subscriber;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MainTest {

    @Test
    public void send_message_to_receiver() throws Exception {

        Publisher publisher = new InMemoryPublisher();
        Subscriber subscriber = new InMemorySubscriber();

        publisher.send(new byte[]{1, 2, 3});

        assertThat(subscriber.readMessage(), equalTo(new byte[]{1, 2, 3}));
    }
}
