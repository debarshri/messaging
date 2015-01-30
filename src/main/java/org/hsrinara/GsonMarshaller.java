package org.hsrinara;

import com.google.gson.Gson;
import org.hsrinara.model.Marshaller;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class GsonMarshaller<T extends ByteBuffer> implements Marshaller<T> {

    private final Gson gson = new Gson();

    public GsonMarshaller() {
        try {
            "canGetCharEncoding".getBytes(Charset.forName(Constants.CHARSET));
        }
        catch (Exception e) {
            throwCannotGetCharEncoding();
        }
    }

    @Override
    public void marshall(final Object toBeMarshalled, final T outputParam) {
        final String json = gson.toJson(toBeMarshalled);
        try {
            outputParam.put(json.trim().getBytes(Constants.CHARSET));
        }
        catch (UnsupportedEncodingException e) {
            throwCannotGetCharEncoding();
        }
    }

    private static void throwCannotGetCharEncoding() {
        throw new IllegalStateException("Cannot get encoding for " + Constants.CHARSET);
    }
}
