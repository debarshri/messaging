package org.hsrinara.model;

public interface Marshaller<O> {
    void marshall(Object toBeMarshalled, O outputParam);
}
