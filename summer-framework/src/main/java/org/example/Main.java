package org.example;

import org.example.summer_framework.Context;

public class Main {
    public static void main(String[] args) {
        Context ctx = new Context("bean.xml");
        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean(Car.class);
    }
}
