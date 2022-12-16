package org.example;

import org.example.summer_framework.Auto;

public class Car {
    @Auto(required = true)
    private Engine engine;
    private Gear gear;

    public Car() {
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }
}
