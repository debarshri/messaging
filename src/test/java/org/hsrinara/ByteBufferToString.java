package org.hsrinara;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferToString {
    public static String toPlainString(final ByteBuffer byteBuffer) {
        return new String(byteBuffer.array(), Charset.forName(Constants.CHARSET)).trim();
    }
}
