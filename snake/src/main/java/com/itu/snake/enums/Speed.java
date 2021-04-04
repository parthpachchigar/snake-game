package com.itu.snake.enums;

public enum Speed {
    SLOWEST(1000),
    SLOW(800),
    MEDIUM(600),
    FAST(400),
    FASTEST(100);

    private int delay;
    Speed(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
}
