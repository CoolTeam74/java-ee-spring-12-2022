package org.example;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

public class Service {
    @Inject
    private Message message;

    private Integer value;
    private String name;

    public void showMessage() {
        System.out.println(message.getMessage());
    }

    @Interceptors(LoggerInterceptor.class)
    public void setValues(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
