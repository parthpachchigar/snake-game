package com.itu.snake.enums;

public enum Speed {
    SLOWEST(800, 1, "SLOW", null),
    SLOW(600, 2, "MEDIUM", "SLOWEST"),
    MEDIUM(400, 3, "FAST", "SLOW"),
    FAST(200, 4, "FASTEST", "MEDIUM"),
    FASTEST(50, 5, null, "FAST");

    private final int delay;
    private final int scoreWeight;
    private final String fasterSpeed;
    private final String slowerSpeed;
    Speed(int delay, int scoreWeight, String fasterSpeed, String slowerSpeed) {
        this.delay = delay;
        this.scoreWeight = scoreWeight;
        this.fasterSpeed = fasterSpeed;
        this.slowerSpeed = slowerSpeed;
    }

    public int getDelay() {
        return delay;
    }

    public int getScoreWeight() {
        return scoreWeight;
    }

    public Speed getFasterSpeed() {
        if(this.fasterSpeed == null) {
            return this;
        }
        return Speed.valueOf(this.fasterSpeed);
    }

    public Speed getSlowerSpeed() {
        if(this.slowerSpeed == null) {
            return this;
        }
        return Speed.valueOf(this.slowerSpeed);
    }
}
