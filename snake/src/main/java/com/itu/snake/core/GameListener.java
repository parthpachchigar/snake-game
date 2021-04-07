package com.itu.snake.core;

import com.itu.snake.enums.GameStatus;

public interface GameListener {
    void onGameStatusChange(GameStatus status);
    void onEat();
}
