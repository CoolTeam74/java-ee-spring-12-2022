package org.example;

import org.example.summer_framework.Context;

public class Main {
    public static void main(String[] args) throws Exception {
        Context ctx = new Context("summer-framework/bean.xml");
        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean(Car.class);
    }
}
