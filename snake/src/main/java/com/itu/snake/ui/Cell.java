package com.itu.snake.ui;

import com.itu.snake.enums.CellType;

import javax.swing.*;

public class Cell extends JPanel {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private CellType type;
    public Cell() {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setType(CellType.EMPTY);
    }

    public void setType(CellType type) {
        this.type = type;
        this.setBackground(type.getColor());
    }

    public CellType getType() {
        return type;
    }
}
