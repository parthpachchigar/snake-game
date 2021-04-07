package com.itu.snake.ui;

import com.itu.snake.core.Game;
import com.itu.snake.enums.GameStatus;
import com.itu.snake.enums.Speed;

import javax.swing.*;

public class StatusPanel extends JLabel {
    public static final int STATUS_PANEL_HEIGHT = 15;
    public StatusPanel(int width) {
        this.setSize(width, STATUS_PANEL_HEIGHT);
        this.setText(String.format("Speed: %s Score: %05d Game Status: %s", Speed.SLOWEST.toString(), 0, GameStatus.ACTIVE));
    }

//    public void update(Game game) {
//        this.setText(String.format("Speed: %s Score: %05d Game Status: %s", game.getSpeed().toString(), game.getScore(), game.getStatus().toString()));
//    }
}
