package com.itu.snake.ui;

import com.itu.snake.enums.Direction;

import com.itu.snake.game.GameStats;
import javax.swing.*;

public class StatusPanel extends JLabel {
    public static final int STATUS_PANEL_HEIGHT = 15;

    public StatusPanel(int width) {
        this.setSize(width, STATUS_PANEL_HEIGHT);
        this.setText("Loading...");
    }

    public void update(Direction direction) {
        this.setText(String.format("Speed: %-10s Score: %05d          Game Status: %-10s Snake Direction: %-10s", GameStats.getSpeed().toString(), GameStats.getScore(), GameStats.getStatus().toString(), direction.toString()));
    }

    public void showMessage(String msg) {
        this.setText(msg);
    }
}
