package org.hsrinara;

import org.hsrinara.model.Marshaller;
import org.junit.Test;

import java.nio.ByteBuffer;

import static org.hamcrest.core.Is.is;
import static org.hsrinara.ByteBufferToString.toPlainString;
import static org.junit.Assert.assertThat;

public class GsonMarshallerTest {

    @Test
    public void should_marshall_output() throws Exception {
        Marshaller<ByteBuffer> marshaller = new GsonMarshaller<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        marshaller.marshall(new Colour("red"), byteBuffer);

        assertThat(toPlainString(byteBuffer), is("{\"name\":\"red\"}"));
    }

    private static class Colour {
        private final String name;

        private Colour(final String name) {
            this.name = name;
        }
    }
}
