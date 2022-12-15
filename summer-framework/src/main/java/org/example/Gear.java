package org.example;

public abstract class Gear {
    private String type;
    private int count;

    protected abstract void nextGear();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
