package com.itu.snake;

import com.itu.snake.ui.Board;

public class SnakeGame {
  public static void main(String[] args) {
    Board gameBoard = new Board(30, 40, 10, 20);
    gameBoard.run();
  }
}
