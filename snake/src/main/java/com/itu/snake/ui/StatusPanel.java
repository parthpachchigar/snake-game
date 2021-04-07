package com.itu.snake.ui;

import com.itu.snake.core.Game;
import com.itu.snake.enums.GameStatus;
import com.itu.snake.enums.Speed;

import com.itu.snake.game.GameStats;
import javax.swing.*;

public class StatusPanel extends JLabel {
    public static final int STATUS_PANEL_HEIGHT = 15;

    public StatusPanel(int width) {
        this.setSize(width, STATUS_PANEL_HEIGHT);
        this.setText("Loading...");
    }

    public void update() {
        this.setText(String.format("Speed: %-10s Score: %05d %5s Game Status: %s", GameStats.getSpeed().toString(), GameStats.getScore(), "", GameStats.getStatus().toString()));
    }
}
