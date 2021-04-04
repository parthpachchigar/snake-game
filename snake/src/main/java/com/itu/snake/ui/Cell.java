package com.itu.snake.ui;

import com.itu.snake.enums.CellType;

import javax.swing.*;
import java.awt.*;

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
        switch (this.type) {
            case FOOD: {
                this.setBackground(Color.RED);
                break;
            }
            case EMPTY: {
                this.setBackground(Color.BLACK);
                break;
            }
            case SNAKE_BODY, SNAKE_HEAD: {
                this.setBackground(Color.GREEN);
                break;
            }
        }
    }

    public CellType getType() {
        return type;
    }
}
