package com.itu.snake.enums;

public enum Speed {
    SLOWEST(800, 1),
    SLOW(600, 2),
    MEDIUM(400, 3),
    FAST(200, 4),
    FASTEST(50, 5);

    private int delay;
    private int scoreWeight;
    Speed(int delay, int scoreWeight) {
        this.delay = delay;
        this.scoreWeight = scoreWeight;
    }

    public int getDelay() {
        return delay;
    }

    public int getScoreWeight() {
        return scoreWeight;
    }
}
