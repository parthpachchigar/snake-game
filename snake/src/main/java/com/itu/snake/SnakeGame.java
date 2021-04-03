package com.itu.snake;

import com.itu.snake.core.GameController;
import com.itu.snake.ui.Board;

public class SnakeGame {
  public static void main(String[] args) {
    Board gameBoard = new Board();
    gameBoard.setVisible(true);

    Thread gameController = new GameController();
    gameController.start();
  }
}
