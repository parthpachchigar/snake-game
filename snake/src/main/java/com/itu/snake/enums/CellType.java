package com.itu.snake.enums;

import java.awt.Color;

public enum CellType {
    EMPTY(new Color(0, 138, 0)),
    FOOD(Color.RED),
    SNAKE_BODY(Color.GREEN),
    SNAKE_HEAD(Color.GREEN),
    SNAKE_TAIL(Color.GREEN),
    TREE(Color.YELLOW);

    private final Color color;

    CellType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}
