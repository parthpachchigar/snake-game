package com.itu.snake.enums;

import java.awt.Color;

public enum CellType {
    EMPTY(Color.BLACK),
    FOOD(Color.RED),
    SNAKE_BODY(Color.GREEN),
    SNAKE_HEAD(Color.GREEN);

    private final Color color;

    CellType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
