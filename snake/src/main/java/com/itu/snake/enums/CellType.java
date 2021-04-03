package com.itu.snake.enums;

import java.awt.Color;

public enum CellType {
    EMPTY(Color.BLACK),
    FOOD(Color.RED),
    BODY(Color.GREEN);

    private Color color;

    CellType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
