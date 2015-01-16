package org.hsrinara.model;

public interface Publisher<T>  {

    void send(T message);

}
